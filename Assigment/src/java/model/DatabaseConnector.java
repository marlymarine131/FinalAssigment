/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hung Nguyen
 */
public class DatabaseConnector {

    protected Connection connection;
    private static final String JDBC_URL = "jdbc:sqlserver://LAPTOP-URP60GBI\\SQLEXPRESS:1433;databaseName=FastFoodAtYourDoor";
    private static final String USER = "sa";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }

    public boolean isEmailDup(String email) {
        List<String> cu = new ArrayList<>();
        String query = "select email from customer";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                cu.add(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String string : cu) {
            if (email.equals(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean insertToCart(int foodID, int cusID) throws SQLException {
        String sql = "INSERT INTO OrderDetail (cusID, foodID, shopID)\n"
                + "VALUES\n"
                + "(?, ?, (SELECT shopID FROM Food WHERE foodID =? ));";
        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cusID);
            preparedStatement.setInt(2, foodID);
            preparedStatement.setInt(3, foodID);
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    public static Customer selectCustomer(int cusID) {
        String query = "SELECT * FROM customer WHERE cusID = ?";
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, cusID);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getInt("cusID"));
                customer.setAddress(resultSet.getString("address"));
                customer.setName(resultSet.getString("Username"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPassWord(resultSet.getString("password"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertCustomer(String address, String phone, String password, String name, String email) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO customer (address, phone, password, name, email) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, address);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, email);

            int effectRow = preparedStatement.executeUpdate();
            return effectRow > 0;
        }
    }

    public Order getOrderByID() {

    }

    public void insertOrder(int cusID) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Order1 (cusID,address)\n"
                + "VALUES\n"
                + "(?,select b.address\n"
                + "from customer b \n"
                + "where b.cusID = ?")) {

            preparedStatement.setInt(1, cusID);
            preparedStatement.setInt(2, cusID);
            preparedStatement.executeUpdate();
        }
    }

    public void updateOrder(int quantity, int orderID, int orderDetailID) throws SQLException {
        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  
                PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE OrderDetail\n"
                + "SET quantity = ?, OrderID = ?\n"
                + "WHERE orderDetailID = ?;")) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, orderID);
            preparedStatement.setInt(3, orderDetailID);
            preparedStatement.executeUpdate();
        }
    }

}
