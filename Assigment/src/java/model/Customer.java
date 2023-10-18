/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hung Nguyen
 */
/**
 *
 * @author Hung Nguyen
 */
public class Customer {
    private int CustomerID;
    private String address;
    private String UserName;
    private String Phone;
    private String PassWord;
    private String Name;
    private String Email;

    public Customer() {
    }

    public Customer(int CustomerID, String address, String UserName, String Phone, String PassWord, String Name, String Email) {
        this.CustomerID = CustomerID;
        this.address = address;
        this.UserName = UserName;
        this.Phone = Phone;
        this.PassWord = PassWord;
        this.Name = Name;
        this.Email = Email;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}
