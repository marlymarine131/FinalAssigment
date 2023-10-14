/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author oteee
 */
public class Owner {
    private int ownerID;
    private String taxNumber;
    private String ownerName;
    private String phone;
    private String description;
    private String email;
    private String addressHead;

    public Owner(int ownerId, String taxNumber, String ownerName, String phone, String description, String email, String addressHead) {
        this.ownerID = ownerId;
        this.taxNumber = taxNumber;
        this.ownerName = ownerName;
        this.phone = phone;
        this.description = description;
        this.email = email;
        this.addressHead = addressHead;
    }

    public Owner() {
    }

    public int getOwnerId() {
        return ownerID;
    }

    public void setOwnerId(int ownerId) {
        this.ownerID = ownerId;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressHead() {
        return addressHead;
    }

    public void setAddressHead(String addressHead) {
        this.addressHead = addressHead;
    }
    
    
}
