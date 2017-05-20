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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

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
   
    protected void saveNewDrinks(ArrayList<String> values){
         try {
            prepare=conn.prepareStatement("INSERT INTO store_drinks(drink_name,cartons,units,wc_price,category,inserted_in)VALUES(?,?,?,?,?,?)");
            prepare.setString(1, values.get(0));
            prepare.setString(2,  values.get(1));
            prepare.setString(3,  values.get(2));
            prepare.setString(4,  values.get(3));
            prepare.setString(5,  values.get(4));
            prepare.setString(6,  values.get(5));
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
                    
                    } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void getDrinkCategories(JComboBox drinkcat){
         try {
            prepare=conn.prepareStatement("SELECT DISTINCT(category) FROM store_drinks");
            rs= prepare.executeQuery();
            while(rs.next()){
                String categoryDrinks=rs.getString("category");
                drinkcat.addItem(categoryDrinks);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
      public void loadcategoryDrinks(JComboBox first,JComboBox second){
         try {
            prepare=conn.prepareStatement("SELECT DISTINCT(drink_name) FROM store_drinks  WHERE category='"+first.getSelectedItem().toString()+"' ");
            rs= prepare.executeQuery();
            second.removeAllItems();
            second.addItem("---Select Drink Name---");
            while(rs.next()){
                String categoryDrinks=rs.getString("drink_name");
                second.addItem(categoryDrinks);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
     
      //This method is controlled.
      public int getDrinkCrateCount(String drinkname){
          int number=0;
        try {
            prepare=conn.prepareStatement("SELECT units FROM store_drinks WHERE drink_name='"+drinkname+"'");
            rs=prepare.executeQuery();
            if(rs.next()){
                number=rs.getInt("units");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return number;
          
      }
    public  String getInsertedForm(String drinkname){
        String savedAs="";
         try {
            prepare=conn.prepareStatement("SELECT inserted_in FROM store_drinks WHERE drink_name='"+drinkname+"'");
            rs=prepare.executeQuery();
            if(rs.next()){
                savedAs=rs.getString("inserted_in");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return savedAs;
    }
     //This is used to update the store_drinks table when its category returned is found to bottled.
    protected void saveBottledDrinksToCounter(String name,String quantity,String sellingprice){
        try {
            prepare=conn.prepareStatement("SELECT inserted_in FROM store_drinks WHERE drink_name='");
            rs=prepare.executeQuery();
            if(rs.next()){
               // savedAs=rs.getString("inserted_in");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          //return savedAs;
        
    }
    //This is used to update the store_drinks table when its category returned is found to crated.
    protected void  insertToCounter(String drink_name,String category,String totalunits,String sellingprices){
         try {
            prepare=conn.prepareStatement("INSERT INTO counter_drinks(drink_name,category,total_units,selling_price)VALUES(?,?,?,?)");
            prepare.setString(1, drink_name);
            prepare.setString(2, category);            
            prepare.setString(3, totalunits);
            prepare.setString(4, sellingprices);
            
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Counter Updated Successfully");        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
   
        
    protected void updateStoreDrinkValue(String name,int quantity){
          try {
            prepare=conn.prepareStatement("UPDATE store_drinks SET cartons=`cartons`-"+quantity+" WHERE drink_name='"+name+"'");         
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Store Drinks  Updated Successfully");        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         protected void updateBottledStoreDrinkValue(String name,int quantity){
          try {
            prepare=conn.prepareStatement("UPDATE store_drinks SET units=`units`-"+quantity+" WHERE drink_name='"+name+"'");         
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Store Drinks  Updated Successfully");        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    protected ResultSet getAlDrinks(JComboBox mydrink){
         try {
           prepare=conn.prepareStatement("SELECT drink_name FROM counter_drinks ORDER BY drink_name ASC");         
           rs=prepare.executeQuery();
           while(rs.next()){
               mydrink.addItem(rs.getString("drink_name"));
               
           }
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
    protected void updateSellingPrices(String drinkname,String sprice){
        try {
           prepare=conn.prepareStatement("UPDATE counter_drinks SET selling_price='"+sprice+"' WHERE drink_name='"+drinkname+"'");         
           prepare.executeUpdate();
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void getDailySales(JTable mytable,String date){
        try {
           prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',SUM(quantity) AS 'TOTAL UNITS',sum(unit_price*quantity) AS 'TOTAL AMOUNT' FROM items_sold WHERE date(time)=CURDATE() GROUP BY drink_name ORDER BY drink_name");         
           rs=prepare.executeQuery();
           mytable.setModel(DbUtils.resultSetToTableModel(rs));
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getWeeklySales(JTable mytable,String endDate){
        try {
           prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',SUM(quantity) AS 'TOTAL UNITS',sum(unit_price*quantity) AS 'TOTAL AMOUNT' FROM items_sold WHERE date(time) BETWEEN DATE_SUB('"+endDate+"',INTERVAL 7 DAY) AND '"+endDate+"' GROUP BY drink_name");         
           rs=prepare.executeQuery();
           mytable.setModel(DbUtils.resultSetToTableModel(rs));
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    public void getMonthlySales(JTable mytable,String month){
        try {
           prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',SUM(quantity) AS 'TOTAL UNITS',sum(unit_price*quantity) AS 'TOTAL AMOUNT' FROM items_sold WHERE MONTH(time)='"+month+"' GROUP BY drink_name");         
           rs=prepare.executeQuery();
           mytable.setModel(DbUtils.resultSetToTableModel(rs));
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    public ArrayList<String> getCurrentDayMonth(){
        ArrayList<String> activedateMonth=new ArrayList<>();
         String activedate="";
         String activeMonth="";      
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date=new Date();
        activedate=sdf.format(date); 
        activedateMonth.add(activedate);
        Calendar cal=Calendar.getInstance();
        activeMonth=new SimpleDateFormat("MM").format(cal.getTime());
        activedateMonth.add(activeMonth);
         
         return activedateMonth;
    }
    
}
