/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.manager;

import bm.admin.DatabaseConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author User
 */
/*This class is just for all information of workers

*/
public class WorkerActions {
    DatabaseConfiguration dbc=new DatabaseConfiguration();
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement prepare;
    
    public WorkerActions(){
        conn=dbc.getConnection();
    }
    
    
    public void getWaiterName(JComboBox mycombo){
        try {
            prepare=conn.prepareStatement("SELECT CONCAT(first_name,' ',last_name) AS 'name' FROM employees WHERE responsibility != 'Director'");
            rs=prepare.executeQuery();
            while(rs.next()){
                mycombo.addItem(rs.getString("name"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public ResultSet getWaiterSaless(String waitername){
        
       try {
            prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',sum(quantity) AS 'TOTAL UNITS SOLD',sum(quantity*unit_price) AS 'EXPECTED TOTAL RETURNS' FROM items_sold WHERE waiter_name='"+waitername+"' group by drink_name");
            rs=prepare.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       return rs;
   } 
    
    public ArrayList<ResultSet> getWaiterSales(String waitername,String day,String month){
         ArrayList <ResultSet> waiterSalesInfo=new ArrayList<>();
        try {      
            //Get waiter total sales for the day.
             prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',sum(quantity) AS 'TOTAL UNITS SOLD',sum(quantity*unit_price) AS 'EXPECTED TOTAL RETURNS' FROM items_sold WHERE waiter_name='"+waitername+"' AND date(time)='"+day+"' group by drink_name");     
             rs=prepare.executeQuery();
             waiterSalesInfo.add(rs); 
            
             //get waiter total sales for the month
             prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',sum(quantity) AS 'TOTAL UNITS SOLD',sum(quantity*unit_price) AS 'EXPECTED TOTAL RETURNS' FROM items_sold WHERE waiter_name='"+waitername+"' AND MONTH(time)='"+month+"'group by drink_name");     
             rs=prepare.executeQuery();
             waiterSalesInfo.add(rs);   
             
        
        } catch (SQLException ex) {
            Logger.getLogger(WorkerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
         return waiterSalesInfo;
    }
    public ResultSet getDailySales(){
        try {      
            //Get waiter total sales for the day.
             prepare=conn.prepareStatement("SELECT drink_name AS 'DRINK',sum(quantity) AS 'TOTAL UNITS SOLD',sum(quantity*unit_price) AS 'EXPECTED TOTAL RETURNS' FROM items_sold WHERE date(time)=CURDATE() group by drink_name");     
             rs=prepare.executeQuery(); 
        
        } catch (SQLException ex) {
            Logger.getLogger(WorkerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
    
    public double getTotalSales(JTable table){
       double totalsales=0.00;
       int rowcount=table.getRowCount();
       
       for(int i=0;i<rowcount;i++){
           totalsales+=Double.parseDouble(table.getModel().getValueAt(i, 2).toString());    
       }
       
        return totalsales;
        
    }
    public double getWaiterDiscount(String waiterName){
        double totalDiscount=0.00;
        try{
            prepare=conn.prepareStatement("SELECT SUM(amount) AS 'total_discount'FROM discount WHERE waiter='"+waiterName+"' GROUP BY waiter");
            rs=prepare.executeQuery();
            if(rs.next()){
                totalDiscount=rs.getDouble("total_discount");
            }
            else{
                totalDiscount=0.00;
            }
            
        }
        catch(SQLException ex){
            //ex.printStackTrace();
           JOptionPane.showMessageDialog(null, "This Account Is Attributed to 0.00 Discount", "Techflay Software Solutions", 0);
            
        }
        
        return totalDiscount;
        
    }
    public ArrayList<Double> getWaiterSummary(String waitername,String day,String month){       
         ArrayList <Double> waiterSummary=new ArrayList<>();
         double totaldiscount=0.00,monthlytotalDiscount=0.00;
         
        try {      
            //Get the waiter Total discount for the day.
             prepare=conn.prepareStatement("SELECT SUM(amount) AS 'total_discount'FROM discount WHERE waiter_name='"+waitername+"' AND date(time)='"+day+"' GROUP BY waiter_name");     
             rs=prepare.executeQuery();
             if(rs.next()){
                 totaldiscount=rs.getDouble("total_discount");
                 
              }
             else{
                totaldiscount=0.00;
             }  
              waiterSummary.add(totaldiscount);
             
              //Monthly Discount
                prepare=conn.prepareStatement("SELECT SUM(amount) AS 'total_discount'FROM discount WHERE waiter_name='"+waitername+"' AND MONTH(time)='"+month+"' GROUP BY waiter_name");     
                rs=prepare.executeQuery();
                if(rs.next()){
                 monthlytotalDiscount=rs.getDouble("total_discount");
                 
              }
             else{
                monthlytotalDiscount=0.00;
             }  
              waiterSummary.add(monthlytotalDiscount);
              
        
        } catch (SQLException ex) {
            Logger.getLogger(WorkerActions.class.getName()).log(Level.SEVERE, null, ex);
        }
         return waiterSummary;
    }
}
