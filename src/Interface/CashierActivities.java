/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import bm.admin.DatabaseConfiguration;
import bm.sales.Cash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import security.SystemUsers;

/**
 *
 * @author User
 */
public class CashierActivities {
    DatabaseConfiguration dbc=new DatabaseConfiguration();
    private ResultSet rs=null;
    private PreparedStatement state=null;
    
    private Connection conn=null;
    public  CashierActivities(){
        conn=dbc.getConnection();
    }
    public static void main(String [] args){
        CashierActivities active=new CashierActivities();
        System.out.println(active.closeDailyStock().get(1));
        System.out.println(active.getplusDiscount());
       
        
        
    }    
    
   
   
   
    
    protected ArrayList<Double> closeDailyStock(){
        ArrayList<Double>totalcollection=new ArrayList<>();
        try {
            //This methods record all the transaction and penalizes all the accounts that are debted
            //It affects the following tables;
            //all unpaid tables
            
            //First of all let us select all the records that we have.
            state=conn.prepareStatement("SELECT SUM(quantity*unit_price) AS 'daily_collection' FROM items_sold WHERE date(time)=CURDATE()");
            rs=state.executeQuery();
            if(rs.next()){
                double totalCollected=rs.getDouble("daily_collection");
                totalcollection.add(totalCollected);
            }
            else{
                totalcollection.add(0.00);
            }
            state=conn.prepareStatement("SELECT SUM(amount_payed) AS 'daily_receipt' FROM received_payments WHERE date(time)=CURDATE()");
            rs=state.executeQuery();
            if(rs.next()){
                double totalReceived=rs.getDouble("daily_receipt");
                totalcollection.add(totalReceived);
            }
            else{
                totalcollection.add(0.00);
            }
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalcollection;
    }
    

    
    
    //This method is used to get the account of the waiter.The amount owed in their account.
  
    protected ResultSet getorderItems(String orderNo){
        try {
            state=conn.prepareStatement("SELECT  drink_name AS 'Drink',quantity AS 'Quantity Bought',unit_price AS 'UNIT PRICE',(quantity*unit_price) AS 'TOTAL AMOUNT' FROM items_sold WHERE order_no = '"+orderNo+"' and p_status=0");
            rs=state.executeQuery();
            
            
            } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    protected ArrayList<Object> orderSummary(String orderNo){
       
        ArrayList<Object> orderDetails=new ArrayList<>();
        
        try {           
             state=conn.prepareStatement("SELECT SUM(quantity) AS 'total_units',round(SUM(unit_price*quantity),2) AS 'total_amount'  FROM items_sold WHERE order_no = '"+orderNo+"' and p_status=0");
             rs=state.executeQuery();
             if(rs.next()){
                 int quantity=rs.getInt("total_units");
                 double total=rs.getDouble("total_amount");
                 orderDetails.add(quantity);
                 orderDetails.add(total);              
             }
            
            
          
            } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderDetails;        
    }
    
    protected void savePayments(String discount,String amountPayable,String amountPayed,String orderNo,String transaction_code,String transaction_mode) {
        
    try {
        float Payable = Float.parseFloat(amountPayable);
        float Payed = Float.parseFloat(amountPayed)+Float.parseFloat(discount);
     
        
        if(Payable <= Payed){
            //Cleared debt
            state=conn.prepareStatement("SELECT order_no from received_payments WHERE order_no='"+orderNo+"'");
            rs=state.executeQuery();
            if(rs.next()){
                state=conn.prepareStatement("UPDATE received_payments SET amount_payed=amount_payed+"+Payable+" WHERE order_no='"+orderNo+"'");
                state.execute();
                recordTransaction(orderNo,amountPayed,transaction_mode,transaction_code);
           
            }
            else{
                 state=conn.prepareStatement("INSERT INTO received_payments (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) "
                         + "VALUES ( (SELECT username FROM system_users WHERE status = 1),  '"+orderNo+"', '"+transaction_mode+"',"
                         + " "+Payable+" , '"+transaction_code+"')");
                 state.execute();
               recordTransaction(orderNo,amountPayed,transaction_mode,transaction_code);
            } 
            conn.prepareStatement("UPDATE items_sold SET p_status = '1' WHERE order_no='"+orderNo+"'").execute();
            JOptionPane.showMessageDialog(null, "Order Payment Updated","Techflay Software Solutions",JOptionPane.INFORMATION_MESSAGE);
        }else{
            // Not cleared debt
           state=conn.prepareStatement("SELECT order_no from received_payments WHERE order_no='"+orderNo+"'");
           rs=state.executeQuery();
            if(rs.next()){
                state=conn.prepareStatement("UPDATE received_payments SET amount_payed=amount_payed+"+Payed+" WHERE order_no='"+orderNo+"'");
                state.execute();
              recordTransaction(orderNo,amountPayed,transaction_mode,transaction_code);
           
            }
            else{
                 state=conn.prepareStatement("INSERT INTO received_payments (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) "
                         + "VALUES ( (SELECT username FROM system_users WHERE status = 1),  '"+orderNo+"', '"+transaction_mode+"',"
                         + " "+Payed+" , '"+transaction_code+"')");
                 state.execute();
                 
                recordTransaction(orderNo,amountPayed,transaction_mode,transaction_code);
            } 
            JOptionPane.showMessageDialog(null, "Order Payment Updated","Techflay Software Solutions",JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
    }
  
    }
    private void recordTransaction(String orderNo,String amountPayed,String transaction_mode,String transaction_code){
    try {        
        double Payed = Float.parseFloat(amountPayed);
        state=conn.prepareStatement("INSERT INTO transactions (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) VALUES ( (SELECT username FROM system_users WHERE status = 1),'"+orderNo+"','"+transaction_mode+"','"+amountPayed+"','"+transaction_code+"')");          
        state.execute();
        JOptionPane.showMessageDialog(null, "Transaction Recorded Successfully");
    } catch (SQLException ex) {
        Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    protected float getPayedAmount(String orderNo){
        float amount=0;
        try {
            state=conn.prepareStatement("SELECT amount_payed from received_payments WHERE order_no='"+orderNo+"'");
            rs=state.executeQuery();
            if(rs.next()){
                amount=(rs.getBigDecimal("amount_payed")).floatValue();
            }
            else{
                amount=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
        
    }
    protected void filterPayment(String orderNo){
        try {
            rs=new CashierActivities().getorderItems(orderNo);
            if(rs.next()){
                
            }
            else{
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    protected void getemployee_details(JTable table){
        try {
            //This will get all employees details
            state=conn.prepareStatement("SELECT employees.id_number AS 'ID NUMBER',CONCAT(employees.first_name,'  ',employees.last_name) AS 'FULL NAME',employees.responsibility AS 'POSITION' ,waiter_float.standing_float AS 'STANDING FLOAT',waiter_float.debt AS 'DEBT' from employees INNER JOIN waiter_float ON employees.id_number=waiter_float.id_number");
            rs=state.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   protected void SaveDailyTransaction(){
        try {
            state=conn.prepareStatement("INSERT INTO control_account (user,total_amount,received_amount) VALUES(?,?,?)");
            state.setString(1, new SystemUsers().getLoggedInUser());
            state.setDouble(2, new CashierActivities().closeDailyStock().get(0));
            state.setDouble(3, new CashierActivities().closeDailyStock().get(1));
            state.execute();
            JOptionPane.showMessageDialog(null, "Stock closed Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   protected String getWaiter(String orderNo){
       String waiterName="";
        try {
            state=conn.prepareStatement("SELECT waiter FROM order_table WHERE order_no='"+orderNo+"'");
            rs=state.executeQuery();
            if(rs.next()){
                waiterName=rs.getString("waiter");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return waiterName;
   }
   
   protected void recordDiscount(String orderno,String waiter,double amount){
        if(amount>0){
            try {
            state=conn.prepareStatement("INSERT INTO discount (order_no,waiter_name,amount) VALUES('"+orderno+"','"+waiter+"','"+amount+"')");
            state.execute();
            JOptionPane.showMessageDialog(null, "Discount Recorded Successfully");
           
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }      
   
        }
        
       
       
   }
  //This method is used to get the all unsettled orders;
   public ResultSet getUnsettledOrders(){
        try {
            state=conn.prepareStatement("SELECT order_no AS 'ORDER No',SUM(quantity*unit_price) AS 'ORDER VALUE' FROM items_sold WHERE p_status=0 GROUP BY order_no");
            rs=state.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;      
   }
   protected String getTotalDailySales(){
       String total_sales="";
       try {
            state=conn.prepareStatement("SELECT SUM(quantity*unit_price) AS 'total_amount' FROM items_sold WHERE date(time)=CURDATE()");
            rs=state.executeQuery();
            if(rs.next()){
                total_sales=rs.getString("total_amount");
                
            }
            else{
                total_sales="0.00";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
       return total_sales;
   } 
   
   public double getplusDiscount(){      
       double change=0,totalplusdiscount=0,totalsales=0.00;
        try {
            state=conn.prepareStatement("SELECT (received_payments.amount_payed+discount.amount) AS 'totalplusdiscount' from received_payments INNER JOIN discount ON received_payments.order_no=discount.order_no");
            rs=state.executeQuery();
            while(rs.next()){
                totalplusdiscount=rs.getDouble("totalplusdiscount");
                
            }
            state=conn.prepareCall("SELECT SUM(quantity*unit_price)as 'total_order' FROM items_sold GROUP BY order_no");
            rs=state.executeQuery();
            
            while(rs.next()){
                totalsales=rs.getDouble("total_order");
            }
            change=totalsales-totalplusdiscount;        
        
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return change;    
}
public ResultSet getStockLevel(){
    try{
      state=conn.prepareStatement("SELECT  counter_drinks.drink_name AS 'DRINK', counter_drinks.total_units AS 'OPENING STOCK' , IfNULL(SUM(items_sold.quantity),0) AS 'QUANTITY SOLD',(counter_drinks.total_units- IfNULL(SUM(items_sold.quantity),0)) AS  'CLOSING STOCK'  from counter_drinks LEFT OUTER  JOIN items_sold ON counter_drinks.drink_name=items_sold.drink_name GROUP BY counter_drinks.drink_name");
      rs=state.executeQuery();
      
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    return rs;
}
public  void closeStock(){
        try {
            state=conn.prepareStatement("CREATE TABLE  shiftingStock LIKE counter_drinks");
            state.executeUpdate();
            
            state=conn.prepareStatement("INSERT INTO shiftingStock SELECT counter_drinks.drink_name,counter_drinks.category,((counter_drinks.total_units)-IfNULL(items_sold.quantity,0)) AS 'CLOSING STOCK',counter_drinks.selling_price FROM counter_drinks LEFT OUTER JOIN items_sold ON counter_drinks.drink_name=items_sold.drink_name");
            state.execute();
            
            state=conn.prepareStatement("DROP TABLE counter_drinks");
            state.executeUpdate();
            
            state=conn.prepareStatement("RENAME TABLE shiftingStock TO counter_drinks");
            state.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Complete");
            
        } catch (SQLException ex) {
            Logger.getLogger(CashierActivities.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
   
   
}
