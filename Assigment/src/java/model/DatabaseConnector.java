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
import java.sql.Statement;
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

    public Order getOrderByID(int OrderID) {
        String query = "SELECT * FROM order1 WHERE OrderID = ?";
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, OrderID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderID(resultSet.getInt("OrderID"));
                order.setCusID(resultSet.getInt("CusID"));
                order.setShipperID(resultSet.getInt("ShipperID"));
                order.setAddress(resultSet.getString("address "));
                order.setStatus(resultSet.getString("status"));
                order.setTotal_price(resultSet.getDouble("total_price"));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order insertOrder(int cusID) throws SQLException {
        Order order = null;

        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Order1 (cusID, address) VALUES (?, (SELECT b.address FROM customer b WHERE b.cusID = ?))",
                Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, cusID);
            preparedStatement.setInt(2, cusID);
            preparedStatement.executeUpdate();

            try ( ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);

                    // Now you can create and return the Order object with the generated OrderID
                    order = new Order();
                    order.setOrderID(orderId);
                    order.setCusID(cusID);
                    // Set other properties of the Order if needed
                    try ( PreparedStatement selectStatement = connection.prepareStatement(
                            "SELECT ShipperID, address, total_price, status FROM Order1 WHERE OrderID = ?")) {

                        selectStatement.setInt(1, orderId);
                        try ( ResultSet resultSet = selectStatement.executeQuery()) {
                            if (resultSet.next()) {
                                order.setShipperID(resultSet.getInt("ShipperID"));
                                order.setAddress(resultSet.getString("address"));
                                order.setTotal_price(resultSet.getDouble("total_price"));
                                order.setStatus(resultSet.getString("status"));
                                // Set other properties based on your Order class
                            } else {
                                // Handle the case where no data was retrieved
                                throw new SQLException("Failed to retrieve Order details.");
                            }
                        }
                    }
                } else {
                    // Handle the case where no keys were generated
                    throw new SQLException("Failed to get the generated OrderID.");
                }
            }
        }

        return order;
    }

    public boolean updateOrder(int quantity, int orderID, int orderDetailID) throws SQLException {
        
        String query = "UPDATE OrderDetail SET quantity = ?, OrderID = ? WHERE orderDetailID = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, orderID);
            preparedStatement.setInt(3, orderDetailID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<orderDetail> getShopID(int shopID) throws SQLException {
        List<orderDetail> sID = new ArrayList<>();
        String query = "SELECT * FROM OrderDetail WHERE shopID = ?";

        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                orderDetail orderDetails = new orderDetail();
                orderDetails.setCusID(resultSet.getInt("cusID"));
                orderDetails.setFoodID(resultSet.getInt("foodID"));
                orderDetails.setShopID(resultSet.getInt("shopID"));
                orderDetails.setQuantity(resultSet.getInt("quantity"));
                orderDetails.setSubTotal(resultSet.getDouble("subTotal"));

                // Assuming you have a method to set other properties of OrderDetail
                // orderDetail.setXXX(resultSet.getXXX("columnName"));
                sID.add(orderDetails);
            }
        }
        return sID;
    }

    public List<orderDetail> getCusID(int cusID) {
        List<orderDetail> cID = new ArrayList<>();
        String query = "SELECT * FROM OrderDetail WHERE cusID = ?";

        try ( Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cusID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderDetail orderDetails = new orderDetail();
                orderDetails.setOrderDetailID(resultSet.getInt("orderDetailID"));
                orderDetails.setQuantity(resultSet.getInt("quantity"));
                orderDetails.setCusID(resultSet.getInt("cusID"));
                orderDetails.setFoodID(resultSet.getInt("foodID"));
                orderDetails.setShopID(resultSet.getInt("shopID"));
                orderDetails.setSubTotal(resultSet.getDouble("subTotal"));
                cID.add(orderDetails);
            }
        } catch (Exception e) {
        }
        return cID;
    }

}
