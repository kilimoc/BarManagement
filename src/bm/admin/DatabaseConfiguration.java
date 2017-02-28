/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuyeibill
 */
public class DatabaseConfiguration {
    Connection conn=null;
    PreparedStatement setUp=null;
    private static final String SERVER="jdbc:mysql://localhost";        
    private static final String USER = "root"; 
    private static final String PASSWORD = "UPKFA<72-(";
    
    public static void main(String [] args){
        new DatabaseConfiguration().getConnection();
        
    }
    public Connection getConnection() {        
       
            try { 
                 conn=DriverManager.getConnection(SERVER,USER,PASSWORD); 
                /* setUp=conn.prepareStatement("CREATE DATABASE IF NOT EXISTS techflay_2_1");
                
                setUp.execute();
                System.out.println("Database CREATED SUCCESSFULLY");
                //create the neccessary tables;*/
                Statement state=conn.createStatement();
                state.execute("USE grill_bar");
                
                //let us now create the tables ;
           /* 
            String workersT="CREATE TABLE IF NOT EXISTS employees_details(IdNo int(8),f_name varchar(20),l_name varchar(40),primary key(idNo))";
            setUp=conn.prepareStatement(workersT);
            setUp.execute();
            System.out.println("Database CREATED SUCCESSFULLY");*/

                              
                //JOptionPane.showMessageDialog(null,"The connection is Successfull","Business Management",JOptionPane.PLAIN_MESSAGE);
               
            }            
            catch (SQLException ex) {
                Logger.getLogger(DatabaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            }/*}
    else{
            JOptionPane.showMessageDialog(null, "Error In Connection.Check your Server Connection Details", "BM", 2);
    
}*/
        return conn;
        
        
    }
        
    
}
