/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.manager;

import bm.admin.DatabaseConfiguration;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Developer
 */
public class ManagerActions {
    DatabaseConfiguration mydb=new DatabaseConfiguration ();
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    
    public ManagerActions(){
        conn=mydb.getConnection();
    }
    
    //This is used tyo save a  new drink.
    public void saveNewDrinks(String category,String name,float cartons,int units,float cost){
        try {
            prepare=conn.prepareStatement("INSERT INTO store_drinks(drink_name,cartons,units,wc_price,category) VALUES(?,?,?,?,?)");
            prepare.setString(1, name);           
            prepare.setFloat(2, cartons);
            prepare.setInt(3, units);
            prepare.setBigDecimal(4, BigDecimal.valueOf(cost));
            prepare.setString(5, category);
            
            
            prepare.execute();            
            JOptionPane.showMessageDialog(null, "Drink Recorded Successfully", "Techflay Software Solutions", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "<html><b>"+name+"</b>  already exists</html>", "Techflay Software Solutions", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    protected void ChangeCh(String str) 
    {
        StringBuilder sb = new StringBuilder("");
     for(int x=0;x<str.length();++x)
     {
         if(Character.isLowerCase(str.charAt(x)))
             sb.append(Character.toUpperCase(str.charAt(x)));
         else if(Character.isUpperCase(str.charAt(x)))
               sb.append(Character.toLowerCase(str.charAt(x)));

     }
     
    }


    
}
