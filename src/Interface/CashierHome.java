/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import addins.MyCalculator;
import bm.admin.ConfirmProcess;
import bm.home.StartScreen;
import bm.sales.Home;
import static com.sun.javafx.runtime.async.BackgroundExecutor.getTimer;
import java.awt.Color;
import java.awt.Desktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import security.SystemUsers;
import worker.WaiterControlAccount;

/**
 *
 * @author User
 */
public class CashierHome extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form CashierHome
     */
    CashierActivities active=new CashierActivities();
    Thread t=null;  
    int hours=0, minutes=0, seconds=0;  
    String timeString = ""; 
    
   
    public CashierHome() {
        initComponents();
        setLocationRelativeTo(null);
        contact.setHorizontalAlignment(SwingConstants.CENTER);
        services.setHorizontalAlignment(SwingConstants.CENTER);
        currenttime.setHorizontalAlignment(SwingConstants.CENTER);
        loggedInText.setHorizontalAlignment(SwingConstants.CENTER);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        logoutText.setHorizontalAlignment(SwingConstants.CENTER);
        
        neworder.setHorizontalAlignment(SwingConstants.CENTER);
        update.setHorizontalAlignment(SwingConstants.CENTER);
        settle.setHorizontalAlignment(SwingConstants.CENTER);
        close.setHorizontalAlignment(SwingConstants.RIGHT);
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
        t=new Thread(this);
        t.start();
        
        name.setText(new SystemUsers().getLoggedInUser());
        //Set unsettled orders
        unsettledO.setModel(DbUtils.resultSetToTableModel(active.getUnsettledOrders()));
        //Get total_sales;
        totalSales.setText("Ksh."+active.getTotalDailySales());
        //maximize window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        userAccount = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        loggedInText = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        logoutText = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalSales = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        footerPanel = new javax.swing.JPanel();
        footer = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        services = new javax.swing.JLabel();
        currenttime = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        neworder = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        update = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        settle = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        close = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        unsettledO = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        logoutmenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TechFlay Software Solutions");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("cashierAccount"); // NOI18N

        header.setBackground(new java.awt.Color(19, 186, 155));
        header.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(19, 186, 155));

        userAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/employees.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        header.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(19, 186, 155));

        loggedInText.setBackground(new java.awt.Color(255, 255, 255));
        loggedInText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loggedInText.setForeground(new java.awt.Color(255, 255, 255));
        loggedInText.setText("You Are Logged In As:");

        name.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));

        logoutText.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logoutText.setForeground(new java.awt.Color(255, 255, 255));
        logoutText.setText("<html><u><a>Logout</a></u></html>");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loggedInText, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutText))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loggedInText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutText, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        header.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(19, 186, 155));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TODAY TOTAL SALES");

        totalSales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalSales.setForeground(new java.awt.Color(255, 255, 255));
        totalSales.setText("Ksh.500000");

        jToggleButton1.setText("Refresh");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalSales, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        header.add(jPanel11, java.awt.BorderLayout.LINE_END);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        footerPanel.setBackground(new java.awt.Color(255, 255, 255));
        footerPanel.setPreferredSize(new java.awt.Dimension(588, 40));
        footerPanel.setLayout(new java.awt.GridLayout(1, 0));

        footer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/accountSettings.png"))); // NOI18N
        footer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        footer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                footerMouseMoved(evt);
            }
        });
        footer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                footerMouseClicked(evt);
            }
        });
        footerPanel.add(footer);

        contact.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contact.setForeground(new java.awt.Color(57, 207, 189));
        contact.setText("<html><u><a>Report Bug</a></u></html>");
        contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactMouseClicked(evt);
            }
        });
        footerPanel.add(contact);

        services.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        services.setForeground(new java.awt.Color(57, 207, 189));
        services.setText("<html><u><a>Our Products</a></u></html>");
        services.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        services.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicesMouseClicked(evt);
            }
        });
        footerPanel.add(services);

        currenttime.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        currenttime.setForeground(new java.awt.Color(57, 207, 189));
        currenttime.setText("<html>Current Timer</html>");
        currenttime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        footerPanel.add(currenttime);

        getContentPane().add(footerPanel, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout(2, 2));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        neworder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/neworder.png"))); // NOI18N
        neworder.setText("<html><strong>New Order</strong><br/>Activate a new customer order</html>");
        neworder.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                neworderMouseMoved(evt);
            }
        });
        neworder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                neworderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(neworder, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(neworder)
                .addContainerGap())
        );

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/updateOrder.png"))); // NOI18N
        update.setText("<html><strong>Update Order</strong><br/>Updates already active customer order</html>");
        update.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                updateMouseMoved(evt);
            }
        });
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        settle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/pay.PNG"))); // NOI18N
        settle.setText("<html><strong>Settle Order</strong><br/>Pays an activated order</html>");
        settle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                settleMouseMoved(evt);
            }
        });
        settle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settleMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(settle, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settle)
                .addContainerGap())
        );

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Techflay/closeStock.png"))); // NOI18N
        close.setText("<html><strong>Close Day Stock</strong><br/>Closes the daily stock.This is done when there are no more selling of drinks</html>");
        close.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                closeMouseMoved(evt);
            }
        });
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close)
                .addContainerGap())
        );

        jPanel3.add(jPanel7);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UNSETTLED ORDERS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        unsettledO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ORDER NUMBER", "ORDER AMOUNT"
            }
        ));
        jScrollPane1.setViewportView(unsettledO);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jMenu6.setText("Refresh");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu1.setText("Sales");

        jMenuItem1.setText("Today");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Current Week");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Current Month ");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Total Sales");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reports");

        jMenuItem5.setText("End of Day Sales");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("End Of Month Sales");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("End of Day Revenue");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("End of Month Revenue");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Expense");

        jMenuItem9.setText("Miscellenous ");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Extras");

        jMenuItem12.setText("Calculator");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("My Account");

        jMenuItem10.setText("Update Details");
        jMenu4.add(jMenuItem10);

        jMenuItem14.setText("Waiter Float");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem13.setText("Waiter Control Account");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        logoutmenu.setText("Logout");
        logoutmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutmenuActionPerformed(evt);
            }
        });
        jMenu4.add(logoutmenu);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void neworderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_neworderMouseMoved
       //Here we change the color and size
       neworder.setForeground(Color.decode("#13BA9B"));
       update.setForeground(Color.BLACK);        
       settle.setForeground(Color.BLACK);
       close.setForeground(Color.BLACK);
    }//GEN-LAST:event_neworderMouseMoved

    private void updateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseMoved
         update.setForeground(Color.decode("#13BA9B"));        
         settle.setForeground(Color.BLACK);
         neworder.setForeground(Color.BLACK);         
         close.setForeground(Color.BLACK);
    }//GEN-LAST:event_updateMouseMoved

    private void settleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settleMouseMoved
        settle.setForeground(Color.decode("#13BA9B"));
        neworder.setForeground(Color.BLACK);
        update.setForeground(Color.BLACK);
        close.setForeground(Color.BLACK);
    }//GEN-LAST:event_settleMouseMoved

    private void closeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseMoved
        settle.setForeground(Color.BLACK);
        neworder.setForeground(Color.BLACK);
        update.setForeground(Color.BLACK);
        close.setForeground(Color.decode("#13BA9B"));
    }//GEN-LAST:event_closeMouseMoved

    private void footerMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseMoved
        //JOptionPane.showMessageDialog(null, "Gives you access to your account settings");
        footer.setToolTipText("<html><strong>System settings and important security options are accessed here</strong></html>");
        
    }//GEN-LAST:event_footerMouseMoved

    private void servicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicesMouseClicked
       openWebpage("http://www.techflay.com/portfolio-1.html");
    }//GEN-LAST:event_servicesMouseClicked

    private void neworderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_neworderMouseClicked
        new Home().setVisible(true);
    }//GEN-LAST:event_neworderMouseClicked

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       MyCalculator calc=new MyCalculator(this, "Techflay Calculator");
       calc.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
       String orderNo=JOptionPane.showInputDialog(null, "Order No","Order Number Needed",JOptionPane.PLAIN_MESSAGE);
       new Home().setVisible(true);
    }//GEN-LAST:event_updateMouseClicked

    private void settleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settleMouseClicked
        String orderNo=JOptionPane.showInputDialog(null, "Order No","Order Number Needed",JOptionPane.INFORMATION_MESSAGE);       
        CashierActivities active=new CashierActivities();
        ResultSet rss=active.getorderItems(orderNo);
        try {
            if(rss.next()){
                SettleOrder sorder=new SettleOrder(CashierHome.this,orderNo);
                sorder.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "This order is fully settled");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CashierHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_settleMouseClicked

    private void contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactMouseClicked
       new ReportProblem().setVisible(true);
    }//GEN-LAST:event_contactMouseClicked

    private void footerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_footerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_footerMouseClicked

    private void settleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settleMouseEntered
       settle.setToolTipText("Settle order is here");
    }//GEN-LAST:event_settleMouseEntered

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        /*JOptionPane.showMessageDialog(null, "Performing this activity is crucial to the accounts.Please ensure that you are actually closing the stock");
        
        ConfirmProcess cp=new ConfirmProcess();
        cp.setVisible(true);*/
         CashierActivities active=new CashierActivities();
        JOptionPane.showMessageDialog(null, "<html><b>These are todays report</b></html>\n\t1:Total Sales: "+active.closeDailyStock().get(0)+"\n\t2:Total Received:"+active.closeDailyStock().get(1),"Techflay Software Solutions",JOptionPane.OK_CANCEL_OPTION);
        
         active.SaveDailyTransaction();
    }//GEN-LAST:event_closeMouseClicked

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       new WaiterControlAccount().setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void logoutmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutmenuActionPerformed
       new SystemUsers().logoutUser();
       new StartScreen().setVisible(true);
       dispose();
       
    }//GEN-LAST:event_logoutmenuActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       //new DailySales().setVisible(true);
       //new DailySales().setVisible(true);
       new DailySales().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
     new WaiterFloat().setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
       unsettledO.setModel(DbUtils.resultSetToTableModel(active.getUnsettledOrders()));
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      //This wil refresh major functions in the form and set things in order.
      //Set unsettled orders
        unsettledO.setModel(DbUtils.resultSetToTableModel(active.getUnsettledOrders()));
        //Get total_sales;
        totalSales.setText("Ksh."+active.getTotalDailySales());
      
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CashierHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel currenttime;
    private javax.swing.JLabel footer;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel loggedInText;
    private javax.swing.JLabel logoutText;
    private javax.swing.JMenuItem logoutmenu;
    private javax.swing.JLabel name;
    private javax.swing.JLabel neworder;
    private javax.swing.JLabel services;
    private javax.swing.JLabel settle;
    private javax.swing.JLabel totalSales;
    private javax.swing.JTable unsettledO;
    private javax.swing.JLabel update;
    private javax.swing.JLabel userAccount;
    // End of variables declaration//GEN-END:variables

    public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URL(urlString).toURI());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void run() {  
      try {  
         while (true) {  
  
            Calendar cal = Calendar.getInstance();  
            hours = cal.get( Calendar.HOUR_OF_DAY );  
            if ( hours > 12 ) hours -= 12;  
            minutes = cal.get( Calendar.MINUTE );  
            seconds = cal.get( Calendar.SECOND );  
  
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
            Date date = cal.getTime();  
            timeString = formatter.format( date );  
  
            printTime();  
  
            t.sleep(1000);  // interval given in milliseconds  
         }  
      }  
      catch (Exception e) { }  
 }  
    public void printTime(){  
       currenttime.setText("Time :"+timeString);  
  }  
    
        
        
    

}
