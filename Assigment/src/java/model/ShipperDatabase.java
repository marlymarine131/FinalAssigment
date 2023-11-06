/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author oteee
 */
public class ShipperDatabase {

    private Connection connection;
    private static String serverName = "LAPTOP-URP60GBI\\SQLEXPRESS";
    private static String dbName = "FastFoodAtYourDoor";
    private static String portNumber = "1433";
    private static String instance = "";
    private static String userId = "sa";
    private static String passWord = "1234";
    private static String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

    public ShipperDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, userId, passWord);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean insertShipper(String password, String name, String email, String address, String phone,int shopID) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord)) {
            String sql = "INSERT INTO Shipper (password, name, email, address, phone,shopID) VALUES (?, ?, ?, ?, ?, ?)";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, phone);
                preparedStatement.setInt(6, shopID);
                int rowEffect = preparedStatement.executeUpdate();
                return rowEffect > 0;
            }
        }
    }

    public Shipper loginShipper(String email, String password) {
        String sql = "SELECT * FROM Shipper WHERE email = ? AND password = ?";
        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Shipper shipper = new Shipper();
                shipper.setAddress(rs.getString("address"));
                shipper.setShipperID(rs.getInt("shipperID"));
                shipper.setEmail(rs.getString("email"));
                shipper.setName(rs.getString("name"));
                shipper.setPassword(rs.getString("password"));
                shipper.setPhone(rs.getString("phone"));
                shipper.setShopID(rs.getInt("shopID"));
                return shipper;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Shipper> getAllShippers() throws SQLException {
        String query = "SELECT * FROM Shipper";
        List<Shipper> shippers = new ArrayList<>();
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int shipperID = resultSet.getInt("shipperID");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int shopID = resultSet.getInt("shopID");
                Shipper shipper = new Shipper(shipperID, address, phone, password, name, email, shopID);
                shippers.add(shipper);
            }
        }
        return shippers;
    }

    public void updateOrderShopStatus(int shipperID, String status) {
        String query = "UPDATE OderShop SET status = ? WHERE ShipperID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, shipperID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

}
