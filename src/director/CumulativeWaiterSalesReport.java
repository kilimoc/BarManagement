/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package director;

import Interface.*;
import bm.admin.DatabaseConfiguration;
import java.awt.BorderLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author User
 */
public class CumulativeWaiterSalesReport extends javax.swing.JFrame {

    /**
     * Creates new form DailySales
     */
    DatabaseConfiguration dbc = new DatabaseConfiguration();
    private Connection conn;
    private PreparedStatement prepare;
    private ResultSet rs;
    public CumulativeWaiterSalesReport() {
        initComponents();
        conn=dbc.getConnection();
        loadCumulativeWaiterSales();
        
        
        
        
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

        dailySalesReport = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dailySalesReport.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dailySalesReportLayout = new javax.swing.GroupLayout(dailySalesReport);
        dailySalesReport.setLayout(dailySalesReportLayout);
        dailySalesReportLayout.setHorizontalGroup(
            dailySalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        dailySalesReportLayout.setVerticalGroup(
            dailySalesReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        getContentPane().add(dailySalesReport, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CumulativeWaiterSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CumulativeWaiterSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CumulativeWaiterSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CumulativeWaiterSalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CumulativeWaiterSalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dailySalesReport;
    // End of variables declaration//GEN-END:variables

    private void loadCumulativeWaiterSales() {
        try{
		InputStream stream = getClass().getResourceAsStream(("/projectReports/CumulativeWaiterSales.jrxml"));
		JasperDesign jd = JRXmlLoader.load(stream);
  		
		JasperReport jr = JasperCompileManager.compileReport(jd);
		JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
		dailySalesReport.removeAll();
		dailySalesReport.setLayout(new BorderLayout());
		JRViewer jrviewer = new JRViewer(jp);
		dailySalesReport.add(jrviewer);
		dailySalesReport.revalidate();
		dailySalesReport.repaint(50L);
		} catch (Exception e) {e.printStackTrace();
                }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
