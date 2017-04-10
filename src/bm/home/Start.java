/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.home;

/**
 *
 * @author Developer
 */
import bm.admin.DatabaseConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import director.AdminAccount;
public class Start {
    DatabaseConfiguration dbc=new DatabaseConfiguration(); 
    //
    private Connection conn;
    private PreparedStatement state;
    private ResultSet rs;
    
    public Start(){
        conn=dbc.getConnection();
        checkAdmin();
        
    }
    public static void main(String [] args){
        Start decide=new Start();
    }
    public final  void checkAdmin(){
        try {
            state=conn.prepareStatement("SELECT username FROM administrator");
            rs=state.executeQuery();
            if(rs.next()){
                    new StartScreen().setVisible(true);
            }
            else{
              AdminAccount myaccount=new AdminAccount();
              myaccount.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
}
