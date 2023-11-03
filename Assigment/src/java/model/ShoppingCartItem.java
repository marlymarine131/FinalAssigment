/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oteee
 */
public class ShoppingCartItem {
    private int cartID;
    private int foodID;
    private int cusID;

    public ShoppingCartItem() {
    }

    
    public ShoppingCartItem(int cartID, int foodID, int cusID) {
        this.cartID = cartID;
        this.foodID = foodID;
        this.cusID = cusID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }
    

    
    
}
