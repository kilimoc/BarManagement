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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Developer
 */
public class Customization {
    DatabaseConfiguration dbc=new DatabaseConfiguration();
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    public Customization(){
        conn=dbc.getConnection();
        
    }
    public static void main(String [] args){
        new Customization().getRowNumber();
    }
    
   protected int getRowNumber(){
        int getrowcount=0;
        try {
            prepare=conn.prepareStatement("SELECT COUNT(drink_name) FROM store_drinks");
            rs=prepare.executeQuery();
            if(rs.next()){
                getrowcount=rs.getInt("COUNT(drink_name)")/4;
                if(getrowcount % 2==0){
                    getrowcount=getrowcount;
                }
                else{
                   getrowcount+=getrowcount; 
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return getrowcount;
    }
   protected void getDrinksCategory(JButton drinkb,JPanel drinkpanel){
        try {
            prepare=conn.prepareStatement("SELECT drink_name  FROM store_drinks WHERE drink_name='"+drinkb.getText()+"'");
            rs=prepare.executeQuery();
            while(rs.next()){
                String drinkname=rs.getString("drink_name");
                 JButton drinkbutton=new JButton(drinkname);                  
                drinkpanel.add(drinkbutton);
                System.out.println(drinkname);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }       
   }
    
}
