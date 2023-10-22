/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oteee
 */
public class OwnerDatabase {
    protected Connection connection;
    private static String serverName = "LAPTOP-URP60GBI\\FOODDELIVERY";
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
}
