/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;
import Interface.CashierHome;
import bm.admin.DatabaseConfiguration;
import bm.manager.ManagerHome;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import director.DirectorHome;
import bm.sales.Home;
import javax.swing.JComboBox;

/**
 *
 * @author Kilimo K Cornelius www.techflay.com
 */

public class SystemUsers {
   DatabaseConfiguration mydb=new DatabaseConfiguration();
   private Connection conn;
   private PreparedStatement state;
   private ResultSet ars;
    public SystemUsers(){
        conn=mydb.getConnection();
    }   
   public void getLoginDetails(String accountHolder,String accountPassword){
       try {
           //pull data from databasel;
   
           state=conn.prepareStatement("select username,password,rank from system_users where username='"+accountHolder+"'and password='"+accountPassword+"'");
           ars=state.executeQuery();
           if(ars.next()){
               String rank=ars.getString("rank");
               switch(rank){
                   case "Director":
                       //let us update the status here
                       state=conn.prepareStatement("UPDATE system_users SET status=1 WHERE username='"+accountHolder+"'");
                       state.execute();
                       new DirectorHome().setVisible(true);
                       break;
                   case "Cashier":
                       state=conn.prepareStatement("UPDATE system_users SET status=1 WHERE username='"+accountHolder+"'");
                       state.execute();
                       new CashierHome().setVisible(true);                       
                       break;
                       
                   case "Manager":
                       state=conn.prepareStatement("UPDATE system_users SET status=1 WHERE username='"+accountHolder+"'");
                       state.execute();
                       new ManagerHome().setVisible(true);
                       break;
                      
               
                 }
           }
           else{
               JOptionPane.showMessageDialog(null, "Wrong Login Credentials.Try Again","Techflay Software Solutions",JOptionPane.ERROR_MESSAGE);
           }
       } catch (SQLException ex) {
           Logger.getLogger(SystemUsers.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
public void logoutUser(){
       try {
           state=conn.prepareStatement("UPDATE system_users SET status=0 WHERE status=1");
           state.execute();
           
       } catch (SQLException ex) {
           Logger.getLogger(SystemUsers.class.getName()).log(Level.SEVERE, null, ex);
       }
} 
public void getUsernames(JComboBox mybox){
       try {
           state=conn.prepareStatement("SELECT username FROM system_users");
          ResultSet rs=state.executeQuery();
          while(rs.next()){
              String usernames=rs.getString("username");
              mybox.addItem(usernames);
          }
           
       } catch (SQLException ex) {
           Logger.getLogger(SystemUsers.class.getName()).log(Level.SEVERE, null, ex);
       }
}
 public String  getLoggedInUser(){
     String username="";
        try {
            state=conn.prepareStatement("SELECT username FROM system_users WHERE status=1");
            ars=state.executeQuery();
            if(ars.next()){
                username=ars.getString("username");
                
                //loggedinuser.setText(username);
            }
            /*else{
                JOptionPane.showMessageDialog(null, "You Must be Logged In to Access This Module.","Techflay Software Solutions",JOptionPane.WARNING_MESSAGE);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return username;
        
    }
}
