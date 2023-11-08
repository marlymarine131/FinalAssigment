/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author oteee
 */
public class orderShop {

    private int orderShopID;
    private int shopID;
    private String status;
    private BigDecimal shopOrderPrice;
    private String address;
    private String phone;
    private Integer shipperID;

    public orderShop() {
    }

    public orderShop(int orderShopID, int shopID, String status, BigDecimal shopOrderPrice, String address, String phone, Integer shipperID) {
        this.orderShopID = orderShopID;
        this.shopID = shopID;
        this.status = status;
        this.shopOrderPrice = shopOrderPrice;
        this.address = address;
        this.phone = phone;
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

    public BigDecimal getShopOrderPrice() {
        return shopOrderPrice;
    }

    public void setShopOrderPrice(BigDecimal shopOrderPrice) {
        this.shopOrderPrice = shopOrderPrice;
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

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    @Override
    public String toString() {
        return "orderShop{" + "orderShopID=" + orderShopID + ", shopID=" + shopID + ", status=" + status + ", shopOrderPrice=" + shopOrderPrice + ", address=" + address + ", phone=" + phone + ", shipperID=" + shipperID + '}';
    }

    
}
