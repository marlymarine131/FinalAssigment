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

    public boolean isEmailDup(String email){
        List<String> cu = new ArrayList<>();
        String query = "select email from customer";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);  
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                cu.add(resultSet.getString("email"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        for (String string : cu) {
            if(email.equals(string)) return true;
        }    
        return false;
    }
}
