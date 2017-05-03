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
       
        
        
    }
    
    
    protected void updateOrder(){
        //This is used to update an order.
        
    }
    
    public void settleOrder(){
        //records all the for each customer
        
        
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
    public void getDailySales(String date){
        //This is required to get te
    }
    
    public void getMonthlySales(int month){
        
    }
    public void getAllSales(){
        
    }
    
    //This method is used to get the account of the waiter.The amount owed in their account.
    public void getWaiterAccountDetails(){
        
    }
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
    
    protected void savePayments(String amountPayable,String amountPayed,String orderNo,String transaction_code,String transaction_mode) {
        
    try {
        float Payable = Float.parseFloat(amountPayable);
        float Payed = Float.parseFloat(amountPayed);
        if(Payable <= Payed){
            //Cleared debt
            state=conn.prepareStatement("SELECT order_no from received_payments WHERE order_no='"+orderNo+"'");
            rs=state.executeQuery();
            if(rs.next()){
                state=conn.prepareStatement("UPDATE received_payments SET amount_payed=amount_payed+"+Payable+" WHERE order_no='"+orderNo+"'");
                state.execute();
                recordTransaction(orderNo,amountPayed,transaction_code,transaction_mode);
           
            }
            else{
                 state=conn.prepareStatement("INSERT INTO received_payments (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) "
                         + "VALUES ( (SELECT username FROM system_users WHERE status = 1),  '"+orderNo+"', '"+transaction_mode+"',"
                         + " "+Payable+" , '"+transaction_code+"')");
                 state.execute();
                recordTransaction(orderNo,amountPayed,transaction_code,transaction_mode);
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
                recordTransaction(orderNo,amountPayed,transaction_code,transaction_mode);
           
            }
            else{
                 state=conn.prepareStatement("INSERT INTO received_payments (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) "
                         + "VALUES ( (SELECT username FROM system_users WHERE status = 1),  '"+orderNo+"', '"+transaction_mode+"',"
                         + " "+Payed+" , '"+transaction_code+"')");
                 state.execute();
                 
                 recordTransaction(orderNo,amountPayed,transaction_code,transaction_mode);
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
        state=conn.prepareStatement("INSERT INTO transactions (cashier_username, order_no, transaction_mode, amount_payed, Transaction_code) VALUES ( (SELECT username FROM system_users WHERE status = 1),?,?,?,?)");
        state.setString(1, orderNo);
        state.setString(2, transaction_mode);
        state.setString(3, amountPayed);
        state.setString(4, transaction_code);       
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
            Logger.getLogger(bm.sales.SettleOrder.class.getName()).log(Level.SEVERE, null, ex);
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
            state=conn.prepareStatement("INSERT INTO discount (order_no,waiter,amount) VALUES('"+orderno+"','"+waiter+"','"+amount+"')");
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
    
}
