/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author shehr
 */
public class DB {

    private static DB INSTANCE = null;
    //private static Connection CONNECTION = null;

    private static PreparedStatement INSERT, UPDATE, DELETE, SEARCH_BY_NAME, SEARCH_BY_CNIC, DATA;

    private DB() {
         try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_programming", "root", "shehroz");
                //Also initilize PreparedStatements

                INSERT = conn.prepareStatement("insert into addressbook values(?,?,?,?,?)");
                DATA = conn.prepareStatement("select * from addressbook ");
                UPDATE = conn.prepareStatement("update addressbook set CNIC = ?, name = ?,address = ?, gender = ?, phone = ? where CNIC = ? ");
                DELETE = conn.prepareStatement("Delete from addressbook where CNIC = ? ");
                SEARCH_BY_CNIC = conn.prepareStatement("Select * from addressbook where CNIC = ?");
                SEARCH_BY_NAME = conn.prepareStatement("Select * from addressbook where name like ?");
            
            } catch (Exception e) {
               Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
            }
           
    }

    public static DB getDBinstance() {
        if (INSTANCE == null) {
            INSTANCE = new DB();
            return INSTANCE;

        } else {
            return INSTANCE;
        }

    }

    public void insertContact(long CNIC, String Name, String Address, String gender, long Phone) {
        try {
            INSERT.setLong(1, CNIC);
            INSERT.setString(2, Name);
            INSERT.setString(3, Address);
            INSERT.setString(4, gender);
            INSERT.setLong(5, Phone);
            int ret = INSERT.executeUpdate();

            if (ret == 1) {
                showMessageDialog(null, "Contact Sucessfully Added");
            } else {
                showMessageDialog(null, "Contact Could'nt be Added");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void updateContact(long new_CNIC, long old_CNIC , String Name, String Address, String gender, long Phone){
        try {
            UPDATE.setLong(1, new_CNIC);
            UPDATE.setString(2, Name);
            UPDATE.setString(3, Address);
            UPDATE.setString(4, gender);
            UPDATE.setLong(5, Phone);
            UPDATE.setLong(6, old_CNIC);
             int ret = UPDATE.executeUpdate();

            if (ret == 1) {
                showMessageDialog(null, "Contact Sucessfully Updated");
            } else {
                showMessageDialog(null, "Contact Could'nt be Updated");
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void deleteContact(long CNIC){
        try {
            DELETE.setLong(1, CNIC);
            int ret = DELETE.executeUpdate();

            if (ret == 1) {
                showMessageDialog(null, "Contact Sucessfully Deleted");
            } else {
                showMessageDialog(null, "Contact Could'nt be Deleted");
            }
            
      
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    

    public ArrayList<Vector> getData() {
        try {
            // This function will return all the vectors that need to be shown in table
            ResultSet rs = DATA.executeQuery();
            //int rows = rs.getM

            ArrayList<Vector> reList = new ArrayList<Vector>();

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getLong(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getLong(5));

                reList.add(v);
            }
            
        return reList;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
     public ArrayList<Vector> getDataByName(String name) {
        try {
            // This function will return all the vectors that need to be shown in table
            SEARCH_BY_NAME.setString(1, "%"+name+"%");
            ResultSet rs = SEARCH_BY_NAME.executeQuery();
            //int rows = rs.getM

            ArrayList<Vector> reList = new ArrayList<Vector>();

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getLong(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getLong(5));

                reList.add(v);
            }
            
        return reList;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

     public ArrayList<Vector> getDataByCNIC(long CNIC) {
        try {
            // This function will return all the vectors that need to be shown in table
            SEARCH_BY_CNIC.setLong(1, CNIC);
            ResultSet rs = SEARCH_BY_CNIC.executeQuery();
            //int rows = rs.getM

            ArrayList<Vector> reList = new ArrayList<Vector>();

            while (rs.next()) {
                Vector v = new Vector();

                v.add(rs.getLong(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getLong(5));

                reList.add(v);
            }
            
        return reList;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
