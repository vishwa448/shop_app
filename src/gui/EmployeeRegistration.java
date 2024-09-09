package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import model.MySQL2;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class EmployeeRegistration extends javax.swing.JFrame {
    
//    load value assging 
    private static HashMap<String, String> employeeTypeMap = new HashMap<>();
    private static HashMap<String, String> genderTypeMap = new HashMap<>();

    //constucter
    public EmployeeRegistration() {
        initComponents();
        
        loadType();
        loadGenderType();
        loadEmployee();
        
    }

    // load employee type 
    private void loadType() {
        
        try {
            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `emplopee_type`");
            
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            
            while (resultSet.next()) {
                vector.add(resultSet.getString("e_type_name"));
                employeeTypeMap.put(resultSet.getString("e_type_name"), resultSet.getString("e_type_id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // load gender
    private void loadGenderType() {
        
        try {
            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `gender`");
            
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            
            while (resultSet.next()) {
                vector.add(resultSet.getString("g_type_name"));
                genderTypeMap.put(resultSet.getString("g_type_name"), resultSet.getString("gender_id"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // load Employee
    private void loadEmployee() {
        
        try {
            ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee`"
                    + "INNER JOIN `emplopee_type`ON `employee`.`emplopee_type_type_id` = `emplopee_type`.`e_type_id` "
                    + "INNER JOIN `gender` ON `employee`.`gender_gender_id` = `gender`.`gender_id`");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("first_name"));
                vector.add(resultSet.getString("last_name"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("password"));
                vector.add(resultSet.getString("gender.g_type_name"));
                vector.add(resultSet.getString("emplopee_type.e_type_name"));
                
                model.addRow(vector);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Employee Registration");

        jLabel2.setText("Email");

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("NIC");

        jLabel6.setText("Mobile");

        jLabel7.setText("Password");

        jLabel8.setText("Gender");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Type");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Crate Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Update Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "First Name", "Last Name", "NIC", "Mobile", "Password", "Gender", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField1)
                                                .addComponent(jTextField2)
                                                .addComponent(jTextField3)
                                                .addComponent(jTextField4)
                                                .addComponent(jTextField5)
                                                .addComponent(jPasswordField1)
                                                .addComponent(jComboBox1, 0, 142, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

// Create Account
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            
            String email = jTextField1.getText();
            String firstName = jTextField2.getText();
            String lastName = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String type = String.valueOf(jComboBox2.getSelectedItem());
            
            if (email.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your email ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                
                JOptionPane.showMessageDialog(this, "Invalid email ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (firstName.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your first name ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (lastName.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your last name ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (nic.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your nic ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (mobile.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your mobile ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                
                JOptionPane.showMessageDialog(this, "Please enter Valid mobile ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (password.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter Password ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
                
                JOptionPane.showMessageDialog(this, "Please enter Valid password ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (gender.equals("Select")) {
                
                JOptionPane.showMessageDialog(this, "Please Select gender type ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (type.equals("Select")) {
                
                JOptionPane.showMessageDialog(this, "Please enter Valid Employee type  ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else {

                //validation 
//                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` WHERE `nic` ='" + nic + "' OR `mobile` = '" + mobile + "' ");
//                if (resultSet.next()) {
//                    if (!resultSet.getString("email").equals(email)) {
//
//                        JOptionPane.showMessageDialog(this, "This mobile number or NIC already used ", "Warning", JOptionPane.WARNING_MESSAGE);
//
//                    }
//                }
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                MySQL2.executeIUD("INSERT INTO `employee`(`email`,`password`,`first_name`,`last_name`,`nic`,`mobile`,`date_registered`,`gender_gender_id`,`emplopee_type_type_id`)"
                        + " VALUES('" + email + "','" + password + "','" + firstName + "','" + lastName + "','" + nic + "','" + mobile + "','" + sdf.format(date) + "','" + genderTypeMap.get(gender) + "','" + employeeTypeMap.get(type) + "')");
                
                loadEmployee();
                reset();
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

//    all clear
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField2.setEditable(true);
        jTable1.clearSelection();
        reset();
//    reset();
    }//GEN-LAST:event_jButton3ActionPerformed

//    Table mouse click load value 
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int row = jTable1.getSelectedRow();
        
        String email = String.valueOf(jTable1.getValueAt(row, 0));
        jTextField1.setText(email);
        
        String firstName = String.valueOf(jTable1.getValueAt(row, 1));
        jTextField2.setText(firstName);
        jTextField2.setEditable(false);
        
        String lasetName = String.valueOf(jTable1.getValueAt(row, 2));
        jTextField3.setText(lasetName);
        
        String nic = String.valueOf(jTable1.getValueAt(row, 3));
        jTextField4.setText(nic);
        
        String mobile = String.valueOf(jTable1.getValueAt(row, 4));
        jTextField5.setText(mobile);
        
        String password = String.valueOf(jTable1.getValueAt(row, 5));
        jPasswordField1.setText(password);
        
        String gender = String.valueOf(jTable1.getValueAt(row, 6));
        jComboBox1.setSelectedItem(gender);
        
        String type = String.valueOf(jTable1.getValueAt(row, 7));
        jComboBox2.setSelectedItem(type);
        
        if (evt.getClickCount() == 2) {
            
            int row1 = jTable1.getSelectedRow();
            String emai1 = String.valueOf(jTable1.getValueAt(row, 0));

//            AddressView addressView = new AddressView();
//            addressView.setVisible(true);
        }
        

    }//GEN-LAST:event_jTable1MouseClicked

//    Update Account
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            
            String firstName = jTextField2.getText();
            String lastName = jTextField3.getText();
            String nic = jTextField4.getText();
            String mobile = jTextField5.getText();
            String password = String.valueOf(jPasswordField1.getPassword());
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String type = String.valueOf(jComboBox2.getSelectedItem());
            
            String email = jTextField1.getText();
            
            if (firstName.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your first name ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (lastName.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your last name ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (nic.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your nic ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (mobile.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "Please enter your mobile ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (password.matches("^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$")) {
                
                JOptionPane.showMessageDialog(this, "Please enter your mobile ", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else {
                
                ResultSet resultSet = MySQL2.executeSearch("SELECT * FROM `employee` SET `password` = '" + nic + "' OR `mobile` ='" + mobile + "' ");
                
                boolean canUpdate = false;

//                System.out.println("can update");
//                loadEmployees();
//                  reset();
                if (resultSet.next()) {
                    if (!resultSet.getString("email").equals(email)) {
                        
                        JOptionPane.showMessageDialog(this, "This Mobile number or NIC already used ", "Warning", JOptionPane.WARNING_MESSAGE);
                        
                    } else {
                        canUpdate = true;
                        
                    }
                } else {
                    canUpdate = true;
                    
                }
                
                if (canUpdate) {
//
//                    MySQL2.executeIUD("UPDATE `employee` SET `password` = '" + password + "', `first_name` = '" + firstName + "', ``last_name` = '" + lastName + "'"
//                            + " `nic` = '" + nic + "', `mobile` = '" + mobile + "',"
//                            + " `employee_type_id` = '" + emploeeTypeMap.get(type) + "', `gender_id` ='" + employeeGenderMap.get(gender) + "'"
//                            + "  WHERE `email` = '" + email + "' ");

                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    //empty input field 
    private void reset() {
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        
    }
}
