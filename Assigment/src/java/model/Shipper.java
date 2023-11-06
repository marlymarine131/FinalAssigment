/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hung Nguyen
 */
public class Shipper {

    private int shipperID;
    private String address;
    private String phone;
    private String password;
    private String name;
    private String email;
    private int shopID;

    // Constructors
    public Shipper() {
    }

    public Shipper(int shipperID, String address, String phone, String password, String name, String email, int shopID) {
        this.shipperID = shipperID;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.email = email;
        this.shopID = shopID;
    }

    // Getters and Setters
    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

}
