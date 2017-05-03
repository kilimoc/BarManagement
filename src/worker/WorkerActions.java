/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worker;

import bm.admin.DatabaseConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class WorkerActions {
    DatabaseConfiguration dbc=new DatabaseConfiguration();
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement state;
    
    public WorkerActions(){
        conn=dbc.getConnection();
    }
    
    
protected void setWaiterControlAccount(){
    
}
    
}
