/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hung Nguyen
 */
public class Cart {
    private List<ShoppingCartItem> lists;

    public Cart() {
        lists = new ArrayList<>();
    }

    public Cart(List<ShoppingCartItem> lists) {
        this.lists = lists;
    }
//    public void addItem(Food food) {
//        // Check if the item already exists in the cart
//        for (ShoppingCartItem list : lists) {
//            if (list.getFood().getFoodID() == food.getFoodID()) {
//                list.setQuantity(list.getQuantity());
//                return;
//            }
//        }
//        ShoppingCartItem newItem = new ShoppingCartItem();
//        newItem.setFood(food);
//        lists.add(newItem);
//    }
    
//     public void removeItem(int foodID) {
//        lists.removeIf(list -> list.getFood().getFoodID() == foodID);
//    }
//    
//     public List<ShoppingCartItem> getItems() {
//        return lists;
//    }
//      public void clearCart() {
//        lists.clear();
//    }
}
