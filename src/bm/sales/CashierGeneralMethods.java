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

/**
 *
 * @author User
 */
public class CashierGeneralMethods {
    DatabaseConfiguration dbc = new DatabaseConfiguration();
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    
    
    protected void getDailySales(){
        conn=dbc.getConnection();
        
        
    }
    
}
