/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import model.UserModel;
import config.DatabaseConfig;

/**
 *
 * @author Admin
 */
public class UserController {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet rs = null;
    PreparedStatement pstm = null;
    DatabaseConfig dbCfg = new DatabaseConfig();
    
    
    public UserController()
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
    
    public void addUser(UserModel um)
    {
        try
        {
            /*stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO tbl_users(fname,lname,username,password) VALUES('"+ sm.getFname() +"','"+ sm.getLname() +"','"+ sm.getAge() +"','"+ sm.getAddress() +"')");*/
            pstm = conn.prepareStatement("INSERT INTO tbl_users(fname,lname,username,password,userlevel) VALUES(?,?,?,?,?)");
            pstm.setString(1, um.getUserFname());
            pstm.setString(2, um.getUserLname());
            pstm.setString(3, um.getUsername());
            pstm.setString(4, um.getPassword());
            pstm.setInt(5, um.getUserlevel());
            pstm.executeUpdate();
            
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("error adding student " + ex.toString());
        }
    }
    
    public void updateUser(UserModel um)
    {
        try
        {
            /*stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO tbl_users(fname,lname,username,password) VALUES('"+ sm.getFname() +"','"+ sm.getLname() +"','"+ sm.getAge() +"','"+ sm.getAddress() +"')");*/
            pstm = conn.prepareStatement("UPDATE tbl_users SET fname=?,lname=?,username=?,password=?,userlevel=? WHERE id=?");
            pstm.setString(1, um.getUserFname());
            pstm.setString(2, um.getUserLname());
            pstm.setString(3, um.getUsername());
            pstm.setString(4, um.getPassword());
            pstm.setInt(5, um.getUserlevel());
            pstm.setInt(6, um.getUserId());
            pstm.executeUpdate();
            
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("error adding student " + ex.toString());
        }
    }
    
    public ResultSet getUserbyid(UserModel um)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,username,password,userlevel FROM tbl_users WHERE id=?");
            pstm.setInt(1, um.getUserId());
            rs = pstm.executeQuery();
            return rs;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public ResultSet getUsers()
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,username,password,userlevel FROM tbl_users");
            rs = pstm.executeQuery();
            return rs;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public void deleteUser(UserModel um)
    {
        try
        {
            pstm = conn.prepareStatement("DELETE FROM tbl_users WHERE id=?");
            pstm.setInt(1, um.getUserId());
            pstm.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.print("error deleting student " + ex.toString());
        }
    }
    
    public UserModel validateUserLogin(UserModel um)
    {
        try
        {
            pstm = conn.prepareStatement("SELECT id,fname,lname,userlevel FROM tbl_users WHERE username=? AND password=?");
            pstm.setString(1, um.getUsername());
            pstm.setString(2, um.getPassword());
            rs = pstm.executeQuery();
            
            if(rs.isBeforeFirst() == true)
            {
                rs.first();
                um.setUserId(Integer.parseInt(rs.getString("id")));
                um.setUserFname(rs.getString("fname"));
                um.setUserLname(rs.getString("lname"));
                um.setUserlevel(Integer.parseInt(rs.getString("userlevel")));
                
                return um;
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
}
