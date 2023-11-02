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
    private String description;
    private BigDecimal price;
    private byte[] imagine;

    public Food() {
    }

    public Food(int foodID, int shopID, String foodName, String description, BigDecimal price, byte[] imagine) {
        this.foodID = foodID;
        this.shopID = shopID;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.imagine = imagine;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Food [foodID=" + foodID + ", shopID=" + shopID + ", foodName=" + foodName
                + ", price=" + price + ", imagine=" + Arrays.toString(imagine) + "]";
    }
}

