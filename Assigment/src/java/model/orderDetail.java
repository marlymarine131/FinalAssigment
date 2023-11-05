/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oteee
 */
public class orderDetail {
    private int orderDetailID;
    private int quantity;
    private int cusID;
    private Integer orderID;
    private int foodID;
    private int shopID;
    private double subTotal;

    public orderDetail(int orderDetailID, int quantity, int cusID, Integer orderID, int foodID, int shopID, double subTotal) {
        this.orderDetailID = orderDetailID;
        this.quantity = quantity;
        this.cusID = cusID;
        this.orderID = orderID;
        this.foodID = foodID;
        this.shopID = shopID;
        this.subTotal = subTotal;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }   
}
