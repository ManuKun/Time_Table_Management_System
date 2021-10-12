/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablems;

import com.sun.glass.events.KeyEvent;
import timetablems.DBConnect;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Supun
 */
public class ManageLecturer extends javax.swing.JFrame {

    /**
     * Creates new form ManageLecturer
     */
    public ManageLecturer() throws SQLException {
        initComponents();
        con = DBConnect.connect();
        
        load();
        //table color
        Ltable.setBackground(Color.white);
        // disabale Maximize button
        setResizable(false);
        //srean center code
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    ResultSet rs;
    
    public void load()
    {
        int a;
        try {
            pst = con.prepareStatement("select * from lecturer");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel)Ltable.getModel();
            df.setRowCount(0);
            
            
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i <= a; i++)
                {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("eid"));
                    v2.add(rs.getString("faculty"));
                    v2.add(rs.getString("department"));
                    v2.add(rs.getString("center"));
                    v2.add(rs.getString("building"));
                    v2.add(rs.getString("level"));
                    v2.add(rs.getString("rank"));  
                }

                df.addRow(v2);
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Ltable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdep = new javax.swing.JComboBox<>();
        txtfac = new javax.swing.JComboBox<>();
        txteid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtbui = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtcen = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtlev = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtran = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        errorname = new javax.swing.JLabel();
        erroreid = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "EmpID", "Faculty", "Department", "Center", "Buliding ", "Level", "Rank"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Ltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Ltable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 956, 239));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Manage Lecturers");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Employee ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 408, 90, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lecturer Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 345, -1, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Department");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 535, 90, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Faculty");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 475, 90, 25));

        txtdep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CSE", "CS", "SE" }));
        txtdep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdepActionPerformed(evt);
            }
        });
        txtdep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdepKeyReleased(evt);
            }
        });
        jPanel1.add(txtdep, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 533, 179, 29));

        txtfac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computing", "Engineering", "Business", "Humanities & Sciences" }));
        txtfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfacActionPerformed(evt);
            }
        });
        txtfac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfacKeyReleased(evt);
            }
        });
        jPanel1.add(txtfac, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 473, 180, 29));

        txteid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteidActionPerformed(evt);
            }
        });
        txteid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txteidKeyReleased(evt);
            }
        });
        jPanel1.add(txteid, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 408, 180, 29));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnameKeyReleased(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 345, 180, 29));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Center");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 345, 54, 25));

        txtbui.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New building", "D-block", "A-block", "SJ-block", "Old building", " " }));
        txtbui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuiKeyReleased(evt);
            }
        });
        jPanel1.add(txtbui, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 404, 190, 29));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Building");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 406, 54, 25));

        txtcen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Malabe", "Metro", "Matara", "Kandy", "Kurunagala", "Jaffna", "" }));
        txtcen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcenKeyReleased(evt);
            }
        });
        jPanel1.add(txtcen, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 345, 190, 29));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Level");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 473, 54, 25));

        txtlev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtlev.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));
        txtlev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtlevKeyReleased(evt);
            }
        });
        jPanel1.add(txtlev, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 471, 190, 29));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Rank");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 535, 54, 25));

        txtran.setEditable(false);
        txtran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtranActionPerformed(evt);
            }
        });
        jPanel1.add(txtran, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 535, 190, 29));

        Update.setBackground(new java.awt.Color(0, 102, 204));
        Update.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        Update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UpdateKeyReleased(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 442, 96, -1));

        Clear.setBackground(new java.awt.Color(0, 102, 204));
        Clear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        Clear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ClearKeyReleased(evt);
            }
        });
        jPanel1.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 393, 96, -1));

        Delete.setBackground(new java.awt.Color(0, 102, 204));
        Delete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 491, 96, -1));

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 47, 157, 30));

        Search.setBackground(new java.awt.Color(0, 102, 204));
        Search.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        Search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        jPanel1.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 46, 96, -1));

        errorname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(errorname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 345, 161, 29));

        erroreid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(erroreid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 408, 161, 29));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetablems/1799658.jpg"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txteidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteidActionPerformed

    private void txtranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtranActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        if(txtname.getText().trim().isEmpty()){
            errorname.setText("* Please Enter Name...");
           
        }
        else
            errorname.setText("");
            
        
        if(txteid.getText().trim().isEmpty()){
            erroreid.setText("* Please Enter EID...");
        }
        else
            erroreid.setText("");
        
        if(txtname.getText().trim().isEmpty() || txteid.getText().trim().isEmpty()){
            Component frame = null;
            
            JOptionPane.showMessageDialog(frame, "Please fill in a valid value!!!");
        
        }
        
        else{
        
        df = (DefaultTableModel) Ltable.getModel();
        
        int selected = Ltable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
            String LecName = txtname.getText();
            String EmpID = txteid.getText();
            String Faculty = txtfac.getSelectedItem().toString();
            String Department = txtdep.getSelectedItem().toString();
            String Center = txtcen.getSelectedItem().toString();
            String Building = txtbui.getSelectedItem().toString();            
            String Leve = txtlev.getSelectedItem().toString();
            String Rank =  Leve + "." + EmpID ;
            txtran.setText(Rank);
            
            int x = JOptionPane.showConfirmDialog(null, "Are you want to update Lecturer?", "Update", JOptionPane.YES_NO_OPTION);
            
        if(x == 0)
        {

        
            try {
                pst = con.prepareStatement("update lecturer set name =?, eid =?, faculty =?, department =?, center =?, building =?, level=?, rank =? where id =?");
                pst.setString(1,LecName);
                pst.setString(2,EmpID);
                pst.setString(3,Faculty);
                pst.setString(4,Department);
                pst.setString(5,Center);
                pst.setString(6,Building);
                pst.setString(7,Leve);
                pst.setString(8,Rank);
                pst.setInt(9,id);
                
                pst.executeUpdate();
                 
                JOptionPane.showMessageDialog(this, "Lecturer Updated Successfully");
                
                txtname.setText("");
                txteid.setText("");
                
                errorname.setText("");
                erroreid.setText("");
                
                load();
            } catch (SQLException ex) {
                Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
        }    
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        df = (DefaultTableModel)Ltable.getModel();
        
        int selected = Ltable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        int x = JOptionPane.showConfirmDialog(null, "Are you want to delete Lecturer?", "Delete", JOptionPane.YES_NO_OPTION);
            
        if(x == 0)
        {
     
        try {
            
            pst = con.prepareStatement("delete from lecturer where id = ?");
            pst.setInt(1,id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this,"Lecturer Deleted Successfully");
            
            txtname.setText("");
            txteid.setText("");
            txtfac.setSelectedIndex(0);
            txtdep.setSelectedIndex(0);
            txtcen.setSelectedIndex(0);
            txtbui.setSelectedIndex(0);
            txtlev.setSelectedIndex(0);
            txtran.setText("");
            
            errorname.setText("");
            erroreid.setText("");
            
            load();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void txtfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfacActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void LtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LtableMouseClicked
        // TODO add your handling code here:
          df = (DefaultTableModel)Ltable.getModel();
        
        int selected = Ltable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        txtname.setText(df.getValueAt(selected, 1).toString());
        txteid.setText(df.getValueAt(selected, 2).toString());
       
        String faculty = (df.getValueAt(selected, 3).toString());
      
            switch(faculty){
                case "Computing" :
                    txtfac.setSelectedIndex(0);
                    break;
                    
                case "Engineering" :
                    txtfac.setSelectedIndex(1);
                    break;
                    
                case "Business" :
                    txtfac.setSelectedIndex(2);
                    break;
                    
                case "Humanities & Sciences" :
                    txtfac.setSelectedIndex(3);
                    break;    
                    
            }
            
            String department = (df.getValueAt(selected, 4).toString());
      
            switch(department){
                case "IT" :
                    txtdep.setSelectedIndex(0);
                    break;
                    
                case "CSE" :
                    txtdep.setSelectedIndex(1);
                    break;    

                case "CS" :
                    txtdep.setSelectedIndex(2);
                    break;
                    
                case "SE" :
                    txtdep.setSelectedIndex(3);
                    break;
                    
            }
            
            String center = (df.getValueAt(selected, 5).toString());
      
            switch(center){
                case "Malabe" :
                    txtcen.setSelectedIndex(0);
                    break;
                    
                case "Metro" : 
                    txtcen.setSelectedIndex(1);
                    break;
                    
                case "Matara" :
                    txtcen.setSelectedIndex(2);
                    break;
                    
                case "Kandy" :
                    txtcen.setSelectedIndex(3);
                    break; 
                    
                case "Kurunagala" :
                    txtcen.setSelectedIndex(4);
                    break;     
                
                case "Jaffna" :
                    txtcen.setSelectedIndex(5);
                    break;
            }
            
            String building = (df.getValueAt(selected, 6).toString());
      
            switch(building){
                case "New building" :
                    txtbui.setSelectedIndex(0);
                    break;
                    
                case "D-block" :
                    txtbui.setSelectedIndex(1);
                    break;
                    
                case "A-block" :
                    txtbui.setSelectedIndex(2);
                    break;
                    
                case "SJ-block" :
                    txtbui.setSelectedIndex(3);
                    break; 
                    
                case "Old building" :
                    txtbui.setSelectedIndex(4);
                    break;       
            }
            
            String level = (df.getValueAt(selected, 7).toString());
      
            switch(level){
                case "1 " :
                    txtlev.setSelectedIndex(0);
                    break;
                    
                case "2" :
                    txtlev.setSelectedIndex(1);
                    break;
                    
                case "3" :
                    txtlev.setSelectedIndex(2);
                    break;
                    
                case "4" :
                    txtlev.setSelectedIndex(3);
                    break; 
                    
                case "5" :
                    txtlev.setSelectedIndex(4);
                    break;          
            }
            
            txtran.setText(df.getValueAt(selected, 8).toString());
      
           
        
    }//GEN-LAST:event_LtableMouseClicked

    private void txtdepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdepActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
            txtname.setText("");
            txteid.setText("");
            txtfac.setSelectedIndex(0);
            txtdep.setSelectedIndex(0);
            txtcen.setSelectedIndex(0);
            txtbui.setSelectedIndex(0);
            txtlev.setSelectedIndex(0);
            txtran.setText("");
            txtsearch.setText("");
            
            df.setRowCount(0);
        try {
            load();
        } catch (Exception ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        String val = txtsearch.getText().toString();
         int a;
         
        try {

            pst  = con.prepareStatement("select * from lecturer where name like '%"+val+"%'");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a= rd.getColumnCount();
            df = (DefaultTableModel)Ltable.getModel();
            df.setRowCount(0);
            
            while(rs.next()){       
                
                Vector v2 = new Vector();
                for(int i =1; i<=a; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("eid"));
                    v2.add(rs.getString("faculty"));
                    v2.add(rs.getString("department"));
                    v2.add(rs.getString("center"));
                    v2.add(rs.getString("building"));
                    v2.add(rs.getString("level"));
                    v2.add(rs.getString("rank")); 
                }
                df.addRow(v2);                
            }                    
        } catch (SQLException ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
                df.setRowCount(0);
                load();
                
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Search.requestFocus();
            }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txteidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txteidKeyReleased
        // TODO add your handling code here:
         String PATTERN = "^[0-9]{6}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txteid.getText());

        if(!match.matches()){
            erroreid.setText("* EID number is incorrect !!");
            Update.setEnabled(false);
        }
        else{
            erroreid.setText(null);
            Update.setEnabled(true);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtfac.requestFocus();
            }
    }//GEN-LAST:event_txteidKeyReleased

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchKeyPressed

    private void txtnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[Mr|Ms|Dr|Prof]{2,4}[.][ ][a-zA-Z]{2,30}[ ][a-zA-Z]{2,30}$";
     //  Pattern patt = Pattern.compile(PATTERN);
     //  Matcher match = patt.matcher(txtname.getText());
        if(!Pattern.matches(PATTERN,txtname.getText())){
            errorname.setText("* Lecturer Name is invalid !");
            Update.setEnabled(false);
        }
        else{
            errorname.setText(null);
            Update.setEnabled(true);
        }
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txteid.requestFocus();
            }
    }//GEN-LAST:event_txtnameKeyReleased

    private void txtfacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfacKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtdep.requestFocus();
            }
    }//GEN-LAST:event_txtfacKeyReleased

    private void txtdepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdepKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtcen.requestFocus();
            }
    }//GEN-LAST:event_txtdepKeyReleased

    private void txtcenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcenKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtbui.requestFocus();
            }
    }//GEN-LAST:event_txtcenKeyReleased

    private void txtbuiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuiKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtlev.requestFocus();
            }
    }//GEN-LAST:event_txtbuiKeyReleased

    private void txtlevKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlevKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Clear.requestFocus();
            }
    }//GEN-LAST:event_txtlevKeyReleased

    private void UpdateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UpdateKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Delete.requestFocus();
            }
    }//GEN-LAST:event_UpdateKeyReleased

    private void ClearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClearKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Update.requestFocus();
            }
    }//GEN-LAST:event_ClearKeyReleased

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
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageLecturer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JTable Ltable;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
    private javax.swing.JLabel erroreid;
    private javax.swing.JLabel errorname;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> txtbui;
    private javax.swing.JComboBox<String> txtcen;
    private javax.swing.JComboBox<String> txtdep;
    private javax.swing.JTextField txteid;
    private javax.swing.JComboBox<String> txtfac;
    private javax.swing.JComboBox<String> txtlev;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtran;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}