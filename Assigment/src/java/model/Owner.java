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
    private String areaServe;
    private String phone;
    private String description;
    private String email;
    private String addressHead;
    private byte[] banner;
    private String password;

    public Owner() {
    }
    
    
    
    
    public Owner(int ownerID, String taxNumber, String ownerName, String areaServe, String phone, String description, String email, String addressHead, byte[] banner, String password) {
        this.ownerID = ownerID;
        this.taxNumber = taxNumber;
        this.ownerName = ownerName;
        this.areaServe = areaServe;
        this.phone = phone;
        this.description = description;
        this.email = email;
        this.addressHead = addressHead;
        this.banner = banner;
        this.password = password;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
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

    public String getAreaServe() {
        return areaServe;
    }

    public void setAreaServe(String areaServe) {
        this.areaServe = areaServe;
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

    public byte[] getBanner() {
        return banner;
    }

    public void setBanner(byte[] banner) {
        this.banner = banner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Owner{" + "ownerID=" + ownerID + ", taxNumber=" + taxNumber + ", ownerName=" + ownerName + ", areaServe=" + areaServe + ", phone=" + phone + ", description=" + description + ", email=" + email + ", addressHead=" + addressHead + ", banner=" + banner + ", password=" + password + '}';
    }
    

    
    
    
}
