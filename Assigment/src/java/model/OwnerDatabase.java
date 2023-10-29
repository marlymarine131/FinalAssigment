/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oteee
 */
public class OwnerDatabase {

    protected Connection connection;
    private static String serverName = "LAPTOP-URP60GBI\\SQLEXPRESS";
    private static String dbName = "FastFoodAtYourDoor";
    private static String portNumber = "1433";
    private static String instance = "";
    private static String userId = "sa";
    private static String passWord = "1234";
    private static String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

    public OwnerDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, userId, passWord);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean insertOwner(String taxNumber, String ownerName, String areaServe, String phone, String description,
            String email, String addressHead, InputStream bannerStream, String password) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord)) {

            String sql = "INSERT INTO Owner ( taxNumber, ownerName, areaServe, phone, decription, email, addressHead,banner, password) VALUES ( ?, ?, ?, ?, ?, ?, ?,?,?)";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, taxNumber);
                preparedStatement.setString(2, ownerName);
                preparedStatement.setString(3, areaServe);
                preparedStatement.setString(4, phone);
                preparedStatement.setString(5, description);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, addressHead);
                preparedStatement.setBlob(8, bannerStream);
                preparedStatement.setString(9, password);
                int rowEffect = preparedStatement.executeUpdate();
                return rowEffect > 0;
            }
        }

    }

    public Owner loginOwner(String email, String password) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord)) {
            String query = "SELECT * FROM Owner WHERE email = ? AND password = ?";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Owner ow = new Owner();
                        ow.setOwnerID(resultSet.getInt("ownerID"));
                        ow.setEmail(resultSet.getString("email"));
                        ow.setPassword(resultSet.getString("password"));
                        ow.setOwnerName(resultSet.getString("ownerName"));
                        ow.setAreaServe(resultSet.getString("areaServe"));
                        ow.setDescription(resultSet.getString("decription"));
                        ow.setAddressHead(resultSet.getString("addressHead"));
                        ow.setTaxNumber(resultSet.getString("taxNumber"));
                        ow.setPhone(resultSet.getString("phone"));
                        ow.setBanner(resultSet.getBytes("banner"));
                        return ow;
                    }
                }
            }
        } 
        return null;
    }

    public List<Owner> getAllOwners() {
        List<Owner> ownerList = new ArrayList<>();
        String query = "SELECT * FROM Owner";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Owner owner = new Owner();
                owner.setOwnerID(resultSet.getInt("ownerID"));
                owner.setTaxNumber(resultSet.getString("taxNumber"));
                owner.setOwnerName(resultSet.getString("ownerName"));
                owner.setAreaServe(resultSet.getString("areaServe"));
                owner.setPhone(resultSet.getString("phone"));
                owner.setDescription(resultSet.getString("decription"));
                owner.setEmail(resultSet.getString("email"));
                owner.setAddressHead(resultSet.getString("addressHead"));
                owner.setBanner(resultSet.getBytes("banner"));
                owner.setPassword(resultSet.getString("password"));

                ownerList.add(owner);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ownerList;
    }
    public boolean addShop(int ownerID,String shopName,String shopAddress,InputStream bannerStream) throws SQLException {
        String INSERT_SHOP_QUERY = "INSERT INTO Shop (ownerID, shopName, shopAddress, banner) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, userId, passWord);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOP_QUERY)) {

            preparedStatement.setInt(1, ownerID);
            preparedStatement.setString(2, shopName);
            preparedStatement.setString(3, shopAddress);
            preparedStatement.setBlob(8, bannerStream);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        }       
    }
    public List<Shop> getAllShop() {
        List<Shop> shopList = new ArrayList<>();
        String query = "SELECT * FROM Shop";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Shop product = new Shop();
                product.setShopID(resultSet.getInt("shopID"));
                product.setOwnerID(resultSet.getInt("ownerID"));
                product.setShopName(resultSet.getString("shopName"));
                product.setShopAddress(resultSet.getString("shopAddress"));
                product.setBanner(resultSet.getBytes("banner"));

                shopList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shopList;
    } 
}
