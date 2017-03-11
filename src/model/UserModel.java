/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class UserModel {
    
    private int userId;
    private String userFname;
    private String userLname;
    private String username;
    private String password;
    private int userlevel;
    
    public UserModel() {
        this.userId = 0;
        this.userFname = "Juan";
        this.userLname = "Dela Cruz";
        this.username = "sample_username";
        this.password = "sample_username";
        this.userlevel = 0;
    }

    public UserModel(int userId, String userFname, String userLname, String username, String password, int userlevel) {
        this.userId = userId;
        this.userFname = userFname;
        this.userLname = userLname;
        this.username = username;
        this.password = password;
        this.userlevel = userlevel;
    }
    
    public UserModel(String userFname, String userLname, String username, String password, int userlevel) {
        this.userFname = userFname;
        this.userLname = userLname;
        this.username = username;
        this.password = password;
        this.userlevel = userlevel;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public int getUserlevel() {
        return userlevel;
    }
    
    
    
    
}
