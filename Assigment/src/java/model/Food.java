/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author oteee
 */
public class Food {

    private int foodID;
    private int shopID;
    private String foodName;
    private BigDecimal price;
    private byte[] imagine;

    // Constructors
    public Food() {
    }

    public Food(int shopID, String foodName, BigDecimal price, byte[] imagine) {
        this.shopID = shopID;
        this.foodName = foodName;
        this.price = price;
        this.imagine = imagine;
    }

    // Getters and setters
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public byte[] getImagine() {
        return imagine;
    }

    public void setImagine(byte[] imagine) {
        this.imagine = imagine;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "Food [foodID=" + foodID + ", shopID=" + shopID + ", foodName=" + foodName
                + ", price=" + price + ", imagine=" + Arrays.toString(imagine) + "]";
    }
}

