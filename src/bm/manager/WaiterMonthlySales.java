/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.manager;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class WaiterMonthlySales extends javax.swing.JFrame {

    /**
     * Creates new form WaiterWeeklySales
     */
    WorkerActions action=new WorkerActions();
    ManagerActions manage=new ManagerActions();
    public WaiterMonthlySales() {
        initComponents();
        setLocationRelativeTo(null);
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
            }
        });
         action.getWaiterName(waiterName);
         manage.getMonthlySales(monthlySalesT, manage.getCurrentDayMonth().get(1));
        getActiveMonthSelected();
        g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        waiterName = new javax.swing.JComboBox<>();
        retrieve = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        mymonth = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totaldiscount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        g_total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        netincome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        monthlySalesT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Waiter Monthly Sales General Information");

        jPanel1.setBackground(new java.awt.Color(19, 186, 155));
        jPanel1.setPreferredSize(new java.awt.Dimension(727, 60));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Each Worker Total Weekly Sales");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Worker");

        waiterName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Worker" }));

        retrieve.setText("Retrieve");
        retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Choose Mpnth");

        mymonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mymonth, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waiterName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(retrieve)
                        .addGap(0, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(waiterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retrieve)
                    .addComponent(jLabel8)
                    .addComponent(mymonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(19, 186, 155));

        jLabel3.setText("Total Discount");

        totaldiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totaldiscount.setText("4500");
        totaldiscount.setEnabled(false);

        jLabel5.setText("Grand Total");

        g_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        g_total.setText("Ksh.70000");
        g_total.setEnabled(false);

        jLabel6.setText("Net Total");

        netincome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        netincome.setText("Ksh.50000");
        netincome.setEnabled(false);

        jLabel7.setText("Current Debt Account");

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setText("0.00");
        jTextField5.setEnabled(false);

        jButton2.setText("View Report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totaldiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(g_total))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(netincome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 179, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totaldiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(g_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(netincome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        monthlySalesT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        monthlySalesT.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(monthlySalesT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveActionPerformed
      int selectedmonth=mymonth.getSelectedIndex();
      if(selectedmonth==0){          
           monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "01").get(1)));
           g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==1){
         monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "02").get(1)));
         g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==2){
         monthlySalesT.setModel(DbUtils.resultSetToTableModel( action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "03").get(1)));
         g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==3){
            monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "04").get(1)));
            g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==4){
           
          monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "05").get(1)));
          g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==5){
          monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "06").get(1)));
          g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==6){
         monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "07").get(1))); 
         g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==7){
        monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "08").get(1)));
        g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==8){
          monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "09").get(1)));
        g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==9){
          monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "10").get(1)));
        g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==10){
           monthlySalesT.setModel(DbUtils.resultSetToTableModel( action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "11").get(1)));
            g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      }
      else if(selectedmonth==11){
            monthlySalesT.setModel(DbUtils.resultSetToTableModel(action.getWaiterSales(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "12").get(1)));
            g_total.setText(String.valueOf(action.getTotalSales(monthlySalesT)));
      } 
      totaldiscount.setText(String.valueOf(action.getWaiterDiscount(waiterName.getSelectedItem().toString())));
      totaldiscount.setText(String.valueOf(action.getWaiterSummary(waiterName.getSelectedItem().toString(), manage.getCurrentDayMonth().get(0), "0"+String.valueOf(selectedmonth+1)).get(1)));
      netincome.setText(String.valueOf(Double.parseDouble(g_total.getText())-Double.parseDouble(totaldiscount.getText())));
     
    }//GEN-LAST:event_retrieveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WaiterMonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaiterMonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaiterMonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaiterMonthlySales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaiterMonthlySales().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField g_total;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable monthlySalesT;
    private javax.swing.JComboBox<String> mymonth;
    private javax.swing.JTextField netincome;
    private javax.swing.JButton retrieve;
    private javax.swing.JTextField totaldiscount;
    private javax.swing.JComboBox<String> waiterName;
    // End of variables declaration//GEN-END:variables

    
   private void getActiveMonthSelected() {
       String activemonth=manage.getCurrentDayMonth().get(1);
       if(activemonth.equals("01")){
            mymonth.setSelectedIndex(0);           
       }
       else if(activemonth.equals("02")){
           mymonth.setSelectedIndex(1);
       }
        else if(activemonth.equals("03")){
           mymonth.setSelectedIndex(2);
       }
        else if(activemonth.equals("04")){
           mymonth.setSelectedIndex(3);
       }
        else if(activemonth.equals("05")){
           mymonth.setSelectedIndex(4);
       }
        else if(activemonth.equals("06")){
           mymonth.setSelectedIndex(5);
       }
        else if(activemonth.equals("07")){
           mymonth.setSelectedIndex(6);
       }
        else if(activemonth.equals("08")){
           mymonth.setSelectedIndex(7);
       }
        else if(activemonth.equals("09")){
           mymonth.setSelectedIndex(8);
       }
        else if(activemonth.equals("10")){
           mymonth.setSelectedIndex(9);
       }
        else if(activemonth.equals("11")){
           mymonth.setSelectedIndex(10);
       }
        else if(activemonth.equals("12")){
           mymonth.setSelectedIndex(11);
       }
   }
       
      

}
