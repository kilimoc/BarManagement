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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
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
     public void saveNewDrinksWithDifferentPrices(String category,String name,float cartons,int units,float cost){
        try {
            prepare=conn.prepareStatement("INSERT INTO store_drinks_new(drink_name,cartons,units,wc_price,category) VALUES(?,?,?,?,?)");
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
    protected void updateCounter(String mydrinkname, String dcategory,float cartons,float tunits,double sellingprice){
       try{
           prepare=conn.prepareStatement("SELECT drink_name FROM counter_drinks WHERE drink_name='"+mydrinkname+"'");
           rs=prepare.executeQuery();
           if(rs.next()){
              prepare=conn.prepareStatement("UPDATE counter_drinks SET cartons=`cartons`+cartons WHERE drink_name='"+mydrinkname+"'");
              prepare.execute();
              System.out.println("Update Successful");

           }
           //insertion takes place here.
           else{          
           
            prepare=conn.prepareStatement("INSERT INTO counter_drinks(drink_name,category,cartons,total_units,selling_price)VALUES(?,?,?,?,?)");
            prepare.setString(1, mydrinkname);
            prepare.setString(2, dcategory);
            prepare.setFloat(3, cartons);
            prepare.setFloat(4, tunits);
            prepare.setBigDecimal(5, BigDecimal.valueOf(sellingprice));
            
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
            
            
        
           }
           //end of insertion code.
       }
       catch(SQLException ex){
           Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }
    //Method to return the number of units per drinkselected
    protected int getDrinkUnits(String drinkname){
        int units=0;
         try{
            prepare=conn.prepareStatement("SELECT units from store_drinks WHERE drink_name='"+drinkname+"'");
            rs=prepare.executeQuery();
           if(rs.next()){
               units=rs.getInt("units");
           }
           else{
               
               JOptionPane.showMessageDialog(null, "The drink is invalid");
           }
        }
        catch(SQLException ex){
            
        }
         return units;
    }
    protected void saveDrinks(String drinkname,String quantity,String bprice){
      //  prepare=conn.prepareStatement("INSERT INTO store_drinks () VALUES(?,?,?)");
        
        
        
    }
    protected void saveBottledDrinks(String category,String name,String quantity,String price){
        
            try {
                prepare=conn.prepareStatement("INSERT INTO store_drinks (drink_name,units,wc_price,category) VALUES(?,?,?,?)");
                prepare.setString(1, name);
                prepare.setString(2, quantity);
                prepare.setString(1, name);
                prepare.setString(1, name);
                prepare.execute();
                
            } catch (SQLException ex) {
                Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    
}
