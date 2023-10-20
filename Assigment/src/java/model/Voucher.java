/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author oteee
 */
public class Voucher {
    private Date dateApplied;
    private Date QueriDate;
    float price;
    int voucherID;
    int foodID;

    public Voucher(Date dateApplied, Date QueriDate, float price, int voucherID, int foodID) {
        this.dateApplied = dateApplied;
        this.QueriDate = QueriDate;
        this.price = price;
        this.voucherID = voucherID;
        this.foodID = foodID;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Date getQueriDate() {
        return QueriDate;
    }

    public void setQueriDate(Date QueriDate) {
        this.QueriDate = QueriDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
    
    
}
