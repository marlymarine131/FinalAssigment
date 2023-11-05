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

    private int orderID;
    private Integer shipperID; // Integer để xử lý giá trị null
    private int cusID;
    private String address;
    private double total_price;
    private String status;

    public Order() {
    }

    
    public Order(int orderID, Integer shipperID, int cusID, String address, double total_price, String status) {
        this.orderID = orderID;
        this.shipperID = shipperID;
        this.cusID = cusID;
        this.address = address;
        this.total_price = total_price;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", shipperID=" + shipperID + ", cusID=" + cusID + ", address=" + address + ", total_price=" + total_price + ", status=" + status + '}';
    }
    
}
