/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.DatabaseConfig;
import java.sql.*;
import model.ContactsModel;


/**
 *
 * @author Admin
 */
public class ContactsController {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet rs = null;
    PreparedStatement pstm = null;
    DatabaseConfig dbCfg = new DatabaseConfig();
    
    
    public ContactsController()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbCfg.getHostAndDatabase(),dbCfg.getDatabaseUsername(),dbCfg.getDatabasePassword());    
        }
        catch(Exception ex)
        {
            System.out.print("Error on DB connection " + ex.toString());
        }
    }
    
    public void addContacts(ContactsModel cm)
    {
        try
        {
            /*stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO tbl_users(fname,lname,username,password) VALUES('"+ sm.getFname() +"','"+ sm.getLname() +"','"+ sm.getAge() +"','"+ sm.getAddress() +"')");*/
            pstm = conn.prepareStatement("INSERT INTO tbl_contacts(fname,lname,age,address,email,contact_no,user_id) VALUES(?,?,?,?,?,?,?)");
            pstm.setString(1, cm.getFname());
            pstm.setString(2, cm.getLname());
            pstm.setInt(3, cm.getAge());
            pstm.setString(4, cm.getAddress());
            pstm.setString(5, cm.getEmail());
            pstm.setInt(6, cm.getContactNo());
            pstm.setInt(7, cm.getUserId());
            pstm.executeUpdate();
            
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("error adding student " + ex.toString());
        }
    }
    
    public void updateContacts(ContactsModel cm)
    {
        try
        {
            /*stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO tbl_users(fname,lname,username,password) VALUES('"+ sm.getFname() +"','"+ sm.getLname() +"','"+ sm.getAge() +"','"+ sm.getAddress() +"')");*/
            pstm = conn.prepareStatement("UPDATE tbl_contacts SET fname=?,lname=?,age=?,address=?,email=?,contact_no=? WHERE id=?");
            pstm.setString(1, cm.getFname());
            pstm.setString(2, cm.getLname());
            pstm.setInt(3, cm.getAge());
            pstm.setString(4, cm.getAddress());
            pstm.setString(5, cm.getEmail());
            pstm.setInt(6, cm.getContactNo());
            pstm.setInt(7, cm.getId());
            pstm.executeUpdate();
            
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("error adding student " + ex.toString());
        }
    }
    
    public ContactsModel checkExistingContact(ContactsModel cm)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,age,address,email,contact_no,user_id FROM tbl_contacts WHERE user_id=?");
            pstm.setInt(1, cm.getUserId());
            rs = pstm.executeQuery();
            if (rs.isBeforeFirst() == true)
            {
                rs.first();
                cm.setUserId(rs.getInt("user_id"));
                return cm;
            }
            else
            {
                return null;
            }
        }
        catch(Exception ex)
        {
            System.out.print("Error on DB " + ex.toString());
            return null;
        }
    }
    
    public ResultSet getContacts(ContactsModel cm)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,age,address,email,contact_no,user_id FROM tbl_contacts WHERE user_id=?");
            pstm.setInt(1, cm.getUserId());
            rs = pstm.executeQuery();
            return rs;
        }
        catch(Exception ex)
        {
            System.out.print("Error on DB " + ex.toString());
            return null;
        }
    }
    
    public void deleteContacts(ContactsModel cm)
    {
        try
        {
            pstm = conn.prepareStatement("DELETE FROM tbl_contacts WHERE id=?");
            pstm.setInt(1, cm.getId());
            pstm.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.print("error deleting student " + ex.toString());
        }
    }
    
    public ResultSet getUserInfo(ContactsModel cm)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,username FROM tbl_users WHERE id=?");
            pstm.setInt(1, cm.getUserId());
            rs = pstm.executeQuery();
            return rs;
        }
        catch(Exception ex)
        {
            System.out.print("Error on DB " + ex.toString());
            return null;
        }
    }
    
    public ResultSet getContactsByConID(ContactsModel cm)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,age,address,email,contact_no,user_id FROM tbl_contacts WHERE id=?");
            pstm.setInt(1, cm.getId());
            rs = pstm.executeQuery();
            return rs;
        }
        catch(Exception ex)
        {
            System.out.print("Error on DB " + ex.toString());
            return null;
        }
    }
    
}
