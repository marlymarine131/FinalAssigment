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
    private double price;
    private byte[] image;

    // Constructors
    public Food() {
    }

    public Food(int foodID, int shopID, String foodName, double price, byte[] image) {
        this.foodID = foodID;
        this.shopID = shopID;
        this.foodName = foodName;
        this.price = price;
        this.image = image;
    }

    // Getters and Setters
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Food [foodID=" + foodID + ", shopID=" + shopID + ", foodName=" + foodName
                + ", price=" + price + ", imagine=" + Arrays.toString(image) + "]";
    }
}

