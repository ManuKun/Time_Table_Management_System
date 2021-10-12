/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class studentGroup extends javax.swing.JFrame {

    
      Connection conn = null;
      PreparedStatement pst  = null;
      ResultSet rs= null;
      DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form studentGroup
     */
    public studentGroup() {
        initComponents();
        
      setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
       
        
        conn =  studentGroup.ConnectDb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        YearBox = new javax.swing.JComboBox<>();
        ProBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        GNBox = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SGNBox = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        GIDBox = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SGIDBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        YearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y1S1", "Y1S2", "Y2S1", "Y2S2", "Y3S1", "Y3S2", "Y4S1", "Y4S2" }));
        YearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearBoxActionPerformed(evt);
            }
        });
        jPanel1.add(YearBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 62, 30));

        ProBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "SE", "DS", "CS", "I M", "ISECSNE" }));
        jPanel1.add(ProBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 64, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Year And Sem");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 129, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Programme");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 30));

        GNBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        jPanel1.add(GNBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 51, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Group number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 129, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sub Group number");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 30));

        SGNBox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        SGNBox.setToolTipText("1,2");
        jPanel1.add(SGNBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 51, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Group ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, 20));

        GIDBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GIDBoxActionPerformed(evt);
            }
        });
        GIDBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GIDBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GIDBoxKeyReleased(evt);
            }
        });
        jPanel1.add(GIDBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 180, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Sub Group ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        SGIDBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SGIDBoxActionPerformed(evt);
            }
        });
        jPanel1.add(SGIDBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 180, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 99, 49));

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 91, 49));

        jButton3.setBackground(new java.awt.Color(0, 51, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Genarate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 94, 44));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 170, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("               Add Student Group");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 432, 54));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    public static Connection ConnectDb()
    {
        
        try
            
        {
            Class.forName("org.sqlite.JDBC");
                     Connection conn = DriverManager.getConnection("jdbc:sqlite:ttms.db");
                     return conn;
        }
        catch(Exception e)
                {
                    
                    JOptionPane.showMessageDialog(null, e);
                    return null;
                }
                
    }
     
    
    
    
    
    
    
    
    
    
    private void YearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        if(GIDBox.getText().length()<=0 || SGIDBox.getText().length()<=0) {
        
        
             JOptionPane.showMessageDialog(null, " please Genarate Id'S");
            
        }
        
        
        
        else{
        
       String sql= "INSERT INTO student(sg_groupnum,sg_subgroupnum,programme,yearsem,groupid,subgroupid)VALUES(?,?,?,?,?,?)";
       
         try
             
         {
             pst = conn.prepareStatement(sql);
             
             
               pst.setInt(1, GNBox.getValue().hashCode());
               pst.setInt(2, SGNBox.getValue().hashCode());
              pst.setString(3,(String) ProBox.getSelectedItem());
              pst.setString(4,(String) YearBox.getSelectedItem());
              pst.setString(5,GIDBox.getText());
              pst.setString(6,(String) SGIDBox.getText());
             
            pst.execute();
             JOptionPane.showMessageDialog(null, " Data Added");
            
            // rs.close();
            // pst.close();
             
       }
        catch(Exception e)
            
        {
            JOptionPane.showMessageDialog(null, e);
        }
         
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    }
         
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String  yearAndsem = YearBox.getSelectedItem().toString();
         String programme  = ProBox.getSelectedItem().toString();
         int groupID = (int) GNBox.getValue();
         int subgroupID = (int) SGNBox.getValue();
         
       GIDBox.setText(yearAndsem+"."+programme+"."+groupID);
       SGIDBox.setText(yearAndsem+"."+programme+"."+groupID+"."+subgroupID);
         
         
         
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void GIDBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GIDBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GIDBoxActionPerformed

    private void SGIDBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SGIDBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SGIDBoxActionPerformed

    private void GIDBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GIDBoxKeyReleased
        // TODO add your handling code here:
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_GIDBoxKeyReleased

    private void GIDBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GIDBoxKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_GIDBoxKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         
         YearBox.setSelectedItem("");
              ProBox.setSelectedItem("");
                // GNBox.setValue("");
                // SGNBox.setValue("");
              GIDBox.setText("");
               SGIDBox.setText("");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(studentGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentGroup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentGroup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GIDBox;
    private javax.swing.JSpinner GNBox;
    private javax.swing.JComboBox<String> ProBox;
    private javax.swing.JTextField SGIDBox;
    private javax.swing.JSpinner SGNBox;
    private javax.swing.JComboBox<String> YearBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}