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
public class ContactsModel {
    
    private int id;
    private String fname;
    private String lname;
    private int age;
    private String address;
    private String email;
    private int contactNo;
    private int userId;

    
    public ContactsModel() {
        this.id = 0;
        this.fname = "Juan";
        this.lname = "Dela Cruz";
        this.age = 0;
        this.address = "Bulacan";
        this.email = "sample@email.com";
        this.contactNo = 0;
        this.userId = 0;
    }
    
    public ContactsModel(int id, String fname, String lname, int age, String address, String email, int contactNo, int userId) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.userId = userId;
    }
    
    public ContactsModel(String fname, String lname, int age, String address, String email, int contactNo, int userId) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getContactNo() {
        return contactNo;
    }

    public int getUserId() {
        return userId;
    }
    
    
    
}
