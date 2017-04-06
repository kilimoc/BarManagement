/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;


import bm.admin.DatabaseConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kilimo K Cornelius www.techflay.com
 */

public class Accounts {
    DatabaseConfiguration mydb=new DatabaseConfiguration();
    private Connection conn;
    private PreparedStatement state;
    private ResultSet rs;
    public Accounts(){
        conn=mydb.getConnection();
        
    }
    //This is the method to settle order.
    public void settleOrder(int ordern,float amountSettled,float balance){
       if(balance>=0){
           String payorder="UPDATE  activated_orders SET status=1 WHERE orderNo='"+ordern+"'";
        try {
            state=conn.prepareStatement(payorder);
            state.execute();
            
            state=conn.prepareStatement("UPDATE orders SET ordervalue=amountpayed+'"+(amountSettled-balance)+"',amountpayed=amountpayed+'"+(amountSettled-balance)+"'WHERE orderNo='"+ordern+"'");
            boolean execute = state.execute();            
            JOptionPane.showMessageDialog(null, "Order Settled Suuccessful","The Grill Prime Junction Restaurant",JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       }
       else{
           try {
                state=conn.prepareStatement("UPDATE orders SET ordervalue='"+(amountSettled-balance)+"',amountpayed=amountpayed+'"+amountSettled+"' WHERE orderNo='"+ordern+"'");
                state.execute();
                JOptionPane.showMessageDialog(null, "This Order Is Partly Settled","The Grill Prime Junction Restaurant",JOptionPane.WARNING_MESSAGE);
        
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
           
       }
        
    }
    
}
