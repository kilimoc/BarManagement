/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.sales;

import bm.admin.DatabaseConfiguration;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tuyeibill
 */
public class Cash extends javax.swing.JDialog {

    /**
     * Creates new form Cash
     */
    
private String orderNo;
private String amount;
private String orderValue;

 private Connection conn;
 private PreparedStatement mydata;
 private ResultSet rs;
 DatabaseConfiguration mydb=new DatabaseConfiguration();

    
    public Cash(JFrame myjframe,String orderNo,String amount,String orderValue) {
        super(myjframe,true);
        initComponents();
        setLocationRelativeTo(null);
        this.orderNo = orderNo;
        this.amount=amount;
        this.orderValue=orderValue;
        passedOrderNo.setText(orderNo);
        amountPayable.setText(amount);
        conn=mydb.getConnection();
        debt.setVisible(false);
        debtL.setVisible(false);
        tcodeL.setVisible(false);
        tcodeT.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        passedOrderNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amountPayable = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        amountPayed = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        changep = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        debtL = new javax.swing.JLabel();
        debt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mode = new javax.swing.JComboBox<>();
        tcodeL = new javax.swing.JLabel();
        tcodeT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Order No");

        passedOrderNo.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        passedOrderNo.setText("1");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setText("ORDER VALUE");

        amountPayable.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        amountPayable.setText("Ksh 500,000");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("AMOUNT PAYED");

        amountPayed.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        amountPayed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountPayedKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("CHANGE");

        changep.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton1.setText("Settle Order And Print Receipt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        debtL.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        debtL.setText("DEBT");

        debt.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("MODE OF PAYMENT");

        mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select Mode--", "CASH", "M~PESA", "MASTERCARD" }));
        mode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modeItemStateChanged(evt);
            }
        });

        tcodeL.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        tcodeL.setText("Transaction Code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(amountPayed, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tcodeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(debtL, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changep)
                            .addComponent(debt)
                            .addComponent(amountPayable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passedOrderNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tcodeT))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passedOrderNo))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amountPayable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(amountPayed))
                .addGap(18, 18, 18)
                .addComponent(tcodeL)
                .addGap(18, 18, 18)
                .addComponent(tcodeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(changep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(debtL)
                    .addComponent(debt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountPayedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountPayedKeyReleased
        String amount=amountPayed.getText();
        float amountp=Float.parseFloat(amount);
        float change=amountp-Float.parseFloat(amountPayable.getText());
        if(change>=0){
        changep.setText(String.valueOf(change));
        }
        else{
            changep.setText(String.valueOf(0.00));
            debtL.setVisible(true);
            debt.setVisible(true);
            debt.setText(String.valueOf(change*-1));
        }
    }//GEN-LAST:event_amountPayedKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        settleOrder();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void modeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modeItemStateChanged
        String modep=mode.getSelectedItem().toString();
        if(modep.equals("M~PESA") || modep.equals("MASTERCARD")){
            tcodeL.setVisible(true);
            tcodeT.setVisible(true);
        }
        else if(modep.equals("CASH")){
             tcodeL.setVisible(false);
             tcodeT.setVisible(false);
        }
    }//GEN-LAST:event_modeItemStateChanged

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountPayable;
    private javax.swing.JTextField amountPayed;
    private javax.swing.JTextField changep;
    private javax.swing.JTextField debt;
    private javax.swing.JLabel debtL;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> mode;
    private javax.swing.JLabel passedOrderNo;
    private javax.swing.JLabel tcodeL;
    private javax.swing.JTextField tcodeT;
    // End of variables declaration//GEN-END:variables

    private void settleOrder() {
     //   JOptionPane.showMessageDialog(null, amountPayable.getText());
        float change=Float.parseFloat(amountPayed.getText())-Float.parseFloat(amountPayable.getText());
        int ordern=Integer.parseInt(passedOrderNo.getText());
        
       // if(change>=0){            
         String payorder="UPDATE  items_sold SET p_status=1 WHERE order_no='"+ordern+"'";
        try {
            
            //This runs if the order is not payed.
            if(Float.parseFloat(orderValue)== Float.parseFloat(amountPayable.getText()) && getChange()>=0){
                
                mydata=conn.prepareStatement(payorder);
                mydata.execute();
                
                newPayment();
               
            }
            else if(Float.parseFloat(orderValue)== Float.parseFloat(amountPayable.getText()) && getChange()<0){
                mydata=conn.prepareStatement("UPDATE received_payments SET amount="+Float.parseFloat(amountPayed.getText())+" WHERE order_no='"+ordern+"'");
                mydata.execute();  
                JOptionPane.showMessageDialog(null, amountPayed);
            }
            //else update the table;
            else if(Float.parseFloat(orderValue)< Float.parseFloat(amountPayable.getText())){
                float amountp=Float.parseFloat(amountPayed.getText())-getChange();
                mydata=conn.prepareStatement("UPDATE received_payments SET amount=amount+"+amountp+" WHERE order_no='"+ordern+"'");
                mydata.execute();  
                JOptionPane.showMessageDialog(null, amountPayed);
            }
                     
            JOptionPane.showMessageDialog(null, "Order Settled Suuccessful","The Grill Prime Junction Restaurant",JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    //}
       // else{
           // JOptionPane.showMessageDialog(null, "Hey");
            
          
                 
            
           
        //}
        
    }
    private float getChange(){
        float change=0;
        float amountpayed=Float.parseFloat(amountPayed.getText());
        float orderBalance=Float.parseFloat(amountPayable.getText());
        
        change=amountpayed-orderBalance;
        
        return change;        
    }
    
    private void  newPayment(){
        float amountPayed=Float.parseFloat(amountPayable.getText())-Float.parseFloat(changep.getText());
    try {
        
        mydata=conn.prepareStatement("INSERT INTO received_payments(order_no,amount) VALUES(?,?)");
        mydata.setInt(1, Integer.parseInt(passedOrderNo.getText()));
        mydata.setBigDecimal(2, BigDecimal.valueOf(amountPayed));  
        mydata.execute();
    } catch (SQLException ex) {
        Logger.getLogger(Cash.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
   
        
        
}
