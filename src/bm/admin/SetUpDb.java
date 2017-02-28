
package Importnat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SetUpDb {
    PreparedStatement setUp=null;
    
    public static void main(String[] args){
        new SetUpDb().getConnection("jdbc:mysql://localhost", "root", "UPKFA<72-(");
    }
    public Connection getConnection(String host,String user,String password){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(host,user,password);
            
            setUp=conn.prepareStatement("CREATE DATABASE IF NOT EXISTS grill_bar");
            setUp.execute();
            System.out.println("Database CREATED SUCCESSFULLY");
            //create the neccessary tables;
            Statement state=conn.createStatement();
            state.execute("USE grill_bar ");
            
            //let us now create the tables ;
            
            String workersT="CREATE TABLE IF NOT EXISTS employees_details(IdNo int(8),f_name varchar(20),l_name varchar(40),primary key(idNo))";
            setUp=conn.prepareStatement(workersT);
            setUp.execute();
            System.out.println("Database CREATED SUCCESSFULLY");
            
            //employee job_details table;
            String workersJobT="CREATE TABLE IF NOT EXISTS employee_jobd(jobNo int not null auto_increment primary key,IdNo int(8) not null,j_group varchar(20) not null,b_salary Decimal(13,2),foreign key(IdNo) REFERENCES employees_details(IdNo))";
            setUp=conn.prepareStatement(workersJobT);
            setUp.execute();
            System.out.println("All Tables Created");
            
             //employee job_details table;
            String storeT="CREATE TABLE IF NOT EXISTS store_drinks(drink_name varchar(20) not null primary key, cartons int(5) not null,units int(5) not null,wc_price decimal(9,2) not null,category varchar(50) not null)";
            setUp=conn.prepareStatement(storeT);
            setUp.execute();
            System.out.println("All Tables Created");
            
            //employee job_details table;
            String counterT="CREATE TABLE IF NOT EXISTS counter_drinks(drinkId int not null auto_increment primary key,drink_name varchar(20) not null, cartons int(5) not null,total_units int(5),FOREIGN KEY(drink_name) REFERENCES store_drinks(drink_name))";
            setUp=conn.prepareStatement(counterT);
            setUp.execute();
            System.out.println("All Tables Created");
            
            //Selling Prices T;
            String sellingPT="CREATE TABLE IF NOT EXISTS selling_prices(drinkNo int not null auto_increment primary key,drink_name varchar(40),selling_price decimal(9,2),FOREIGN KEY(drink_name) REFERENCES store_drinks(drink_name))";
            setUp=conn.prepareStatement(sellingPT);
            setUp.execute();
            System.out.println("Selling Prices Activated.");
            
            //orders table;
            String ordersT="CREATE TABLE IF NOT EXISTS orders(orderNo int not null auto_increment primary key,IdNo int(8) not null,orderValue decimal(13,2) not null default 0,amountpayed decimal(13,2) not null default 0, FOREIGN KEY(IdNo) REFERENCES employees_details(IdNo))";
            setUp=conn.prepareStatement(ordersT);
            setUp.execute();
            System.out.println("Orders T created");
            //activated_orders table;
            String activatedOT="CREATE TABLE IF NOT EXISTS activated_orders(item_No  int not null auto_increment primary key,orderNo int  not null,drink_name varchar(40) not null,units int not null,unit_price decimal(9,2)not null,total_cost decimal(9,2) not null,status boolean not null default 0,date TIMESTAMP null default CURRENT_TIMESTAMP,FOREIGN KEY(orderNo) REFERENCES orders(orderNo))";
            setUp=conn.prepareStatement(activatedOT);
            setUp.execute();
            System.out.println("AACTIVATED ORDERS CREATED");
            
            //employee job_details table;
            String salesT="CREATE TABLE IF NOT EXISTS sales(drinkId int not null auto_increment primary key,drink_name varchar(20) not null, units int(5) not null,date TIMESTAMP null default CURRENT_TIMESTAMP,FOREIGN KEY(drink_name) REFERENCES store_drinks(drink_name))";
            setUp=conn.prepareStatement(salesT);
            setUp.execute();
            System.out.println("All Tables Created");
            
            //employee job_details table;
            String mpesasales="CREATE TABLE IF NOT EXISTS mpesa_sales(orderNo int not null,amount decimal(13,2) not null, transaction_code varchar(50) not null primary key,date TIMESTAMP null default CURRENT_TIMESTAMP,FOREIGN KEY(orderNo) REFERENCES orders(orderNo))";
            setUp=conn.prepareStatement(mpesasales);
            setUp.execute();
            System.out.println("MPESA TABLE CREATED");
            //employee job_details table;
            String scardsales="CREATE TABLE IF NOT EXISTS scard_sales(orderNo int not null,amount decimal(13,2) not null, transaction_code varchar(50) not null primary key,date TIMESTAMP null default CURRENT_TIMESTAMP,FOREIGN KEY(orderNo) REFERENCES orders(orderNo))";
            setUp=conn.prepareStatement(scardsales);
            setUp.execute();
            System.out.println("SCARD Created");
            //employee job_details table;
            String systemac="CREATE TABLE IF NOT EXISTS system_users(emplId int null,username varchar(50) not null primary key,password varchar(200) not null,rank varchar(20) not null,status boolean not null default 0)";
            setUp=conn.prepareStatement(systemac);
            setUp.execute();
            System.out.println("System Users Table Created");
            
             //Miscellenous Expenses
            String misc="CREATE TABLE IF NOT EXISTS misc_expenses(expenseId int not null auto_increment primary key,name varchar(50) not null ,quantity int not null,amount decimal(13,2) not null,date TIMESTAMP  null default CURRENT_TIMESTAMP)";
            setUp=conn.prepareStatement(misc);
            setUp.execute();
            System.out.println("Misc Expenses Table created");
             //Miscellenous Expenses
            String dev="CREATE TABLE IF NOT EXISTS developer_d(c_name varchar(50) not null primary key, director varchar(40),phone varchar(13) not null,address varchar(50) not null,location varchar(50),website varchar(50),date TIMESTAMP  null default CURRENT_TIMESTAMP)";
            setUp=conn.prepareStatement(dev);
            setUp.execute();
            System.out.println("Misc Expenses Table created");
            
            JOptionPane.showMessageDialog(null, "All Dependencies Set","The Grill Prime Junction Restaurant",JOptionPane.INFORMATION_MESSAGE);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SetUpDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
        
    }
    
}
