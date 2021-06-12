
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shehr
 */
public class Screen extends javax.swing.JFrame {

    private DB db;
    private javax.swing.JPanel Controls;
    private javax.swing.JButton Add_button;
    private javax.swing.JTextField Address;
    private javax.swing.JLabel Address_Label;
    private javax.swing.JTextField CNIC;
    private javax.swing.JLabel CNIC_Label;
    private javax.swing.JButton Clear_button;
    private javax.swing.JButton Delete_button;
    private javax.swing.JComboBox<String> Gender_Choice;
    private javax.swing.JLabel Heading;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel Name_Label;
    private javax.swing.JTextField Phone;
    private javax.swing.JLabel Phone_Label;
    private javax.swing.JButton Update_button;
    private javax.swing.JTable addressbook;
    private javax.swing.JLabel gender_Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_button;

    public Screen() {
        
        java.awt.GridBagConstraints gridBagConstraints;
        db = DB.getDBinstance();
        Heading = new javax.swing.JLabel();
        Controls = new javax.swing.JPanel();
        Name_Label = new javax.swing.JLabel();
        Address_Label = new javax.swing.JLabel();
        gender_Label = new javax.swing.JLabel();
        Phone_Label = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        Phone = new javax.swing.JTextField();
        Add_button = new javax.swing.JButton();
        Delete_button = new javax.swing.JButton();
        Update_button = new javax.swing.JButton();
        search_button = new javax.swing.JButton();
        CNIC_Label = new javax.swing.JLabel();
        CNIC = new javax.swing.JTextField();
        Clear_button = new javax.swing.JButton();
        Gender_Choice = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressbook = new javax.swing.JTable();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        // Initilize Labels
        Heading.setFont(new java.awt.Font("Times New Roman", 0, 48)); 
        Heading.setText("Address Book");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 700, 0, 0);
        getContentPane().add(Heading, gridBagConstraints);

        Controls.setBackground(new java.awt.Color(204, 204, 204));
        Controls.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24), new java.awt.Color(0, 0, 255))); 
        Controls.setLayout(new java.awt.GridBagLayout());

        CNIC_Label.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        CNIC_Label.setText("CNIC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(92, 83, 0, 0);
        Controls.add(CNIC_Label, gridBagConstraints);
        
        Name_Label.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        Name_Label.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 83, 0, 0);
        Controls.add(Name_Label, gridBagConstraints);

        Address_Label.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        Address_Label.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 83, 0, 0);
        Controls.add(Address_Label, gridBagConstraints);

        gender_Label.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        gender_Label.setText("Gender");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 83, 0, 0);
        Controls.add(gender_Label, gridBagConstraints);

        Phone_Label.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        Phone_Label.setText("Phone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 83, 0, 0);
        Controls.add(Phone_Label, gridBagConstraints);

        // Intilize TextFields
        CNIC.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(86, 19, 0, 115);
        Controls.add(CNIC, gridBagConstraints);
        
        Name.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 115);
        Controls.add(Name, gridBagConstraints);

        Address.setFont(new java.awt.Font("Times New Roman", 0, 22)); 
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 19, 0, 115);
        Controls.add(Address, gridBagConstraints);

        Phone.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 19, 0, 115);
        Controls.add(Phone, gridBagConstraints);
        
        // Initlize Buttons
        Add_button.setText("Add");
        Add_button.setBackground(new java.awt.Color(102, 102, 255));
        Add_button.setForeground(new java.awt.Color(255, 255, 255));
        Add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_buttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 83, 0, 0);
        Controls.add(Add_button, gridBagConstraints);
        
        
        Delete_button.setText("Delete");
        Delete_button.setBackground(new java.awt.Color(102, 102, 255));
        Delete_button.setForeground(new java.awt.Color(255, 255, 255));
        Delete_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delete_buttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 5, 0, 0);
        Controls.add(Delete_button, gridBagConstraints);
        
        
        Update_button.setText("Update");
        Update_button.setBackground(new java.awt.Color(102, 102, 255));
        Update_button.setForeground(new java.awt.Color(255, 255, 255));
        Update_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Update_buttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 20, 0, 0);
        Controls.add(Update_button, gridBagConstraints);
        
        search_button.setText("Search");
        search_button.setBackground(new java.awt.Color(102, 102, 255));
        search_button.setForeground(new java.awt.Color(255, 255, 255));
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_buttonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 18, 0, 115);
        Controls.add(search_button, gridBagConstraints);
        
        
        
        Clear_button.setText("Clear");
        Clear_button.setBackground(new java.awt.Color(102, 102, 255));
        Clear_button.setForeground(new java.awt.Color(255, 255, 255));
        Clear_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clear_buttonMouseClicked(evt);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 49, 49, 0);
        Controls.add(Clear_button, gridBagConstraints);
        
        
        Gender_Choice.setFont(new java.awt.Font("Times New Roman", 0, 20));
        Gender_Choice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 67;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 19, 0, 115);
        Controls.add(Gender_Choice, gridBagConstraints);
        
        
        // Finally Add Control Plan to Grid Bag
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 63, 37, 0);
        getContentPane().add(Controls, gridBagConstraints);

        addressbook.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addressbook.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {"CNIC", "Name", "Address", "gender", "Phone"}));
        addressbook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressbookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(addressbook);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 174, 37, 44);
        getContentPane().add(jScrollPane1, gridBagConstraints);
        
        pack();
        load_data();
     
    }
    
    
    private void Add_buttonMouseClicked(java.awt.event.MouseEvent evt) {                                        

        try {

            if (ValidateData()) {
                long CNIC = Long.parseLong(this.CNIC.getText());
                long Phone = Long.parseLong(this.Phone.getText());

                db.insertContact(CNIC, Name.getText(), Address.getText(), Gender_Choice.getSelectedItem().toString(), Phone);
                load_data();
            }
        } catch (Exception e) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
            showMessageDialog(null, "Please Enter valid values");
        }

    }  
    
     private void Delete_buttonMouseClicked(java.awt.event.MouseEvent evt) {                                           
        try {
            long cnic = Long.parseLong(this.CNIC.getText());
            db.deleteContact(cnic);
            load_data();
            
            CNIC.setText("");
            Name.setText("");
            Address.setText("");
            Gender_Choice.setSelectedIndex(0);
            //Gender.setText("");
            Phone.setText("");
            
            CNIC.requestFocus();


        } catch (NumberFormatException e) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
            showMessageDialog(null, "Please Enter valid values");
        }
    }                                          

    private void Update_buttonMouseClicked(java.awt.event.MouseEvent evt) {                                           
        try {
            if(ValidateData()) {
                long new_CNIC = Long.parseLong(this.CNIC.getText());
                long Phone = Long.parseLong(this.Phone.getText());

                DefaultTableModel table = (DefaultTableModel) addressbook.getModel();
                int selected_row = addressbook.getSelectedRow();

                long old_CNIC = Long.parseLong(table.getValueAt(selected_row, 0).toString());

                db.updateContact(new_CNIC, old_CNIC, Name.getText(), Address.getText(), Gender_Choice.getSelectedItem().toString(), Phone);
                load_data();
            }
        } catch (Exception e) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
            showMessageDialog(null, "Please Enter valid values");
        }
    }                                          

    private void search_buttonMouseClicked(java.awt.event.MouseEvent evt) {                                           

        DefaultTableModel table = (DefaultTableModel) addressbook.getModel();
        table.setRowCount(0); // Clear any Previous Data

        ArrayList<Vector> data;
        long cnic;

        if (!CNIC.getText().isEmpty()) {

            try {
                cnic = Long.parseLong(CNIC.getText().toString());
            } catch (Exception e) {
                showMessageDialog(null, "Enter a valid CNIC");
                load_data();
                return;
            }
            data = db.getDataByCNIC(cnic);
            for (Vector v : data) {
                table.addRow(v);
            }

        } else if (!Name.getText().isEmpty()) {

            data = db.getDataByName(Name.getText());
            for (Vector v : data) {
                table.addRow(v);
            }

        } else {
            showMessageDialog(null, "Enter CNIC or Name in order to Search");
        }
    }                                          

    private void addressbookMouseClicked(java.awt.event.MouseEvent evt) {                                         
        DefaultTableModel table = (DefaultTableModel) addressbook.getModel();
        int selected_row = addressbook.getSelectedRow();
        
        CNIC.setText(table.getValueAt(selected_row, 0).toString());
        Name.setText(table.getValueAt(selected_row, 1).toString());
        Address.setText(table.getValueAt(selected_row, 2).toString());
        Gender_Choice.setSelectedItem(table.getValueAt(selected_row, 3));
        //Gender.setText(table.getValueAt(selected_row, 3).toString());
        Phone.setText(table.getValueAt(selected_row, 4).toString());
        
    } 
    
     private void Clear_buttonMouseClicked(java.awt.event.MouseEvent evt) {                                          

        CNIC.setText("");
        Name.setText("");
        Address.setText("");
        //Gender.setText("");
        Phone.setText("");
        load_data();

    } 

    private void load_data() {

        DefaultTableModel table = (DefaultTableModel) addressbook.getModel();
        table.setRowCount(0); // Clear any Previous Data

        ArrayList<Vector> data = DB.getDBinstance().getData();

        for (Vector v : data) {
            table.addRow(v);
        }

    }

    private boolean ValidateData() {
        // Check of any of the field are blank

        if (CNIC.getText() == "" || Address.getText() == "" || Phone.getText() == "" || Gender_Choice.getSelectedItem().toString()== "" || Name.getText() == "") {
            return false;
        } else {
           int  c = CNIC.getText().length();
            if (CNIC.getText().length()!=13){
                showMessageDialog(null,"The CNIC must be of 13 Digits");
                return false;
            }
            return true;
        }
    }


    public static void main(String args[]) {

        // Set theme
       // UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
       // System.out.println(lafInfo.length);

       // for(UIManager.LookAndFeelInfo e :lafInfo){
      //      System.out.println(e.getName());
     //   }
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            
            }
         }
         catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
            
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Screen().setVisible(true);
            }
        });
    }

}
