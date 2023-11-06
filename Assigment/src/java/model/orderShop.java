/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oteee
 */
public class orderShop {

    private int orderShopID;
    private int shopID;
    private String status;
    private String address;
    private double shopOrderPrice;
    private Integer shipperID;

    public orderShop() {
    }

    public orderShop(int orderShopID, int shopID, String status, String address, double shopOrderPrice, Integer shipperID) {
        this.orderShopID = orderShopID;
        this.shopID = shopID;
        this.status = status;
        this.address = address;
        this.shopOrderPrice = shopOrderPrice;
        this.shipperID = shipperID;
    }

    public int getOrderShopID() {
        return orderShopID;
    }

    public void setOrderShopID(int orderShopID) {
        this.orderShopID = orderShopID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getShopOrderPrice() {
        return shopOrderPrice;
    }

    public void setShopOrderPrice(double shopOrderPrice) {
        this.shopOrderPrice = shopOrderPrice;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    
}
