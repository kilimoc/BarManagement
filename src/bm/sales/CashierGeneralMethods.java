/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.sales;

import bm.admin.DatabaseConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CashierGeneralMethods {
    DatabaseConfiguration dbc = new DatabaseConfiguration();
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    
    
    public CashierGeneralMethods(){
        conn=dbc.getConnection();
    }
    
    public ArrayList<Double> getDailyTotalSales(String day){
        ArrayList<Double> dailySales=new ArrayList<>();
        double totalsales=0.00;
        double totalmpesasales=0.00;
        double totalcashsales=0.00;
        double totalmastercardsales=0.00;
        try {
            //get the total daily sales;
            prepare=conn.prepareStatement("SELECT SUM(amount_payed) as 'total_collected' FROM transactions WHERE date(time)='"+day+"'");
            rs=prepare.executeQuery();
            if(rs.next()){
                totalsales=rs.getDouble("total_collected");
                dailySales.add(totalsales);
            }
            else{
                dailySales.add(totalsales);
            }
            //let us get total CASH Sales Here
             prepare=conn.prepareStatement("SELECT SUM(amount_payed) as 'total_collectedmpesa' FROM transactions WHERE date(time)='"+day+"' AND transaction_mode='M~PESA'");
            rs=prepare.executeQuery();
            if(rs.next()){
                totalmpesasales=rs.getDouble("total_collectedmpesa");
                dailySales.add(totalmpesasales);
            }
            else{
                dailySales.add(totalmpesasales);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CashierGeneralMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return dailySales;        
    }
    
    
}
