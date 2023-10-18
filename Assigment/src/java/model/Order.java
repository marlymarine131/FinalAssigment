/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hung Nguyen
 */
public class Order {
    private String address;
    private String UserName;
    private int CustomerID;
    private String Email;
    private String PassWord;
    private String phone;
    private int quantity;
    private double TotalPrice;
    private int FoodID;
    private int ShipperID;
    private int ShopID;
    private String status;

    public Order() {
    }

    public Order(String address, String UserName, int CustomerID, String Email, String PassWord, String phone, int quantity, double TotalPrice, int FoodID, int ShipperID, int ShopID, String status) {
        this.address = address;
        this.UserName = UserName;
        this.CustomerID = CustomerID;
        this.Email = Email;
        this.PassWord = PassWord;
        this.phone = phone;
        this.quantity = quantity;
        this.TotalPrice = TotalPrice;
        this.FoodID = FoodID;
        this.ShipperID = ShipperID;
        this.ShopID = ShopID;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public String getUserName() {
        return UserName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getPhone() {
        return phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public int getFoodID() {
        return FoodID;
    }

    public int getShipperID() {
        return ShipperID;
    }

    public int getShopID() {
        return ShopID;
    }

    public String getStatus() {
        return status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    public void setShipperID(int ShipperID) {
        this.ShipperID = ShipperID;
    }

    public void setShopID(int ShopID) {
        this.ShopID = ShopID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}