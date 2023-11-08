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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Part;

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

    public boolean addShop(int ownerID, String shopName, String shopAddress, InputStream bannerStream) throws SQLException {
        String INSERT_SHOP_QUERY = "INSERT INTO Shop (ownerID, shopName, shopAddress, banner) VALUES (?, ?, ?, ?)";
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOP_QUERY)) {

            preparedStatement.setInt(1, ownerID);
            preparedStatement.setString(2, shopName);
            preparedStatement.setString(3, shopAddress);
            preparedStatement.setBlob(4, bannerStream);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        }
    }

    public List<Shop> getAllShop() {
        List<Shop> shopList = new ArrayList<>();
        String query = "SELECT * FROM Shop ";
//                + "where ownerID = ?";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {
//            preparedStatement.setInt(1, ownerID);
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

    public List<Shop> getShopByOwnerID(int ownerId) throws SQLException {
        List<Shop> shopList = new ArrayList<>();
        String query = "SELECT * FROM Shop where ownerID = ?";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Shop product = new Shop();
                product.setShopID(resultSet.getInt("shopID"));
                product.setOwnerID(resultSet.getInt("ownerID"));
                product.setShopName(resultSet.getString("shopName"));
                product.setShopAddress(resultSet.getString("shopAddress"));
                product.setBanner(resultSet.getBytes("banner"));
                shopList.add(product);
            }
        }

        return shopList;
    }

    public boolean deleteShop(int shopID) throws SQLException {
        try ( PreparedStatement statement = connection.prepareStatement("DELETE FROM Shop WHERE shopID = ?")) {
            statement.setInt(1, shopID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public Shop getShopByID(int shopID) {
        Shop shop = null;
        String query = "SELECT * FROM Shop WHERE shopID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                shop = new Shop();
                shop.setShopID(resultSet.getInt("shopID"));
                shop.setOwnerID(resultSet.getInt("ownerID"));
                shop.setShopName(resultSet.getString("shopName"));
                shop.setShopAddress(resultSet.getString("shopAddress"));
                shop.setBanner(resultSet.getBytes("banner"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shop;
    }

    public List<Food> getFoodsByShopID(int shopID) {
        List<Food> foods = new ArrayList<>();
        String query = "SELECT * FROM Food WHERE shopID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodID(resultSet.getInt("foodID"));
                food.setShopID(resultSet.getInt("shopID"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setPrice(resultSet.getBigDecimal("price"));
                food.setImagine(resultSet.getBytes("imagine"));

                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foods;
    }

    public Food getFoodbyID(int foodID) {

        String query = "SELECT * FROM Food where foodID = ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, foodID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodID(resultSet.getInt("foodID"));
                food.setShopID(resultSet.getInt("shopID"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setPrice(resultSet.getBigDecimal("price"));
                food.setImagine(resultSet.getBytes("imagine"));
                return food;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Food> getFoods() {
        List<Food> foods = new ArrayList<>();
        String query = "SELECT * FROM Food";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodID(resultSet.getInt("foodID"));
                food.setShopID(resultSet.getInt("shopID"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setPrice(resultSet.getBigDecimal("price"));
                food.setImagine(resultSet.getBytes("imagine"));

                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foods;
    }

    public boolean addFood(int shopID, String foodName, String decription, BigDecimal price, InputStream image) throws SQLException {
        String query = "INSERT INTO Food (shopID, foodName,decription, price, imagine) VALUES (?,?, ?, ?, ?)";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopID);
            preparedStatement.setString(2, foodName);
            preparedStatement.setString(3, decription);
            preparedStatement.setBigDecimal(4, price);
            preparedStatement.setBlob(5, image);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<ShoppingCartItem> listCard() {
        List<ShoppingCartItem> foods = new ArrayList<>();
        String query = "select * from OrderDetail";
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ShoppingCartItem cs = new ShoppingCartItem();
                cs.setCartID(resultSet.getInt("cartID"));
                cs.setFoodID(resultSet.getInt("foodID"));
                cs.setCusID(resultSet.getInt("cusID"));
                foods.add(cs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public List<Food> listCartFood(int cusID) {
        List<Food> foods = new ArrayList<>();
        String query = "select c.foodID,c.foodName,c.price,c.shopID,c.decription,c.imagine\n"
                + "from customer a inner join OrderDetail b on a.cusID  = b.cusID\n"
                + "inner join Food c on c.foodID = b.foodID "
                + "where  a.cusID = ?";
        try ( Connection connection = DriverManager.getConnection(url, userId, passWord);  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cusID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Food food = new Food();
                food.setFoodID(resultSet.getInt("foodID"));
                food.setShopID(resultSet.getInt("shopID"));
                food.setFoodName(resultSet.getString("foodName"));
                food.setDescription(resultSet.getString("decription"));
                food.setPrice(resultSet.getBigDecimal("price"));
                food.setImagine(resultSet.getBytes("imagine"));
                foods.add(food);
            }
            return foods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public List<orderShop> processOrderDetails(List<Integer> shopIDs, int cusID) throws SQLException {
        List<orderShop> orderShopList = new ArrayList<>();
        for (Integer shopID : shopIDs) {
            orderShopList.add(insertOrderShop(shopID, cusID));
        }
        return orderShopList;
    }

   public List<Integer> getShopIDs(int cusID) throws SQLException {
    String query = "SELECT DISTINCT shopID FROM OrderDetail where cusID = ?";
    List<Integer> shopIDs = new ArrayList<>();
    
    try (Connection connection = DriverManager.getConnection(url, userId, passWord);
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
         
        preparedStatement.setInt(1, cusID); // Move this line up to set the parameter before executing the query
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int shopID = resultSet.getInt("shopID");
            shopIDs.add(shopID);
        }
    }

    return shopIDs;
}


    public orderShop insertOrderShop(int shopID, int cusID) throws SQLException {
        String query = "INSERT INTO OrderShop (shopID, address, phone) "
                + "OUTPUT INSERTED.orderShopID, INSERTED.status, INSERTED.shopOrderPrice, INSERTED.address, INSERTED.phone, INSERTED.ShipperID "
                + "VALUES (?, (SELECT TOP 1 c.address FROM OrderDetail a "
                + "INNER JOIN Customer c ON a.cusID = c.cusID "
                + "INNER JOIN OrderShop b ON b.shopID = a.shopID "
                + "WHERE a.shopID = ? AND c.cusID = ?), "
                + "(SELECT TOP 1 c.phone FROM OrderDetail a "
                + "INNER JOIN Customer c ON a.cusID = c.cusID "
                + "INNER JOIN OrderShop b ON b.shopID = a.shopID "
                + "WHERE a.shopID = ? AND c.cusID = ?))";

        try ( Connection connection = DriverManager.getConnection(url, userId, passWord); 
                PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            statement.setInt(1, shopID);
            statement.setInt(2, shopID);
            statement.setInt(3, cusID);
            statement.setInt(4, shopID);
            statement.setInt(5, cusID);

            boolean hasResults = statement.execute();
            if (hasResults) {
                try ( ResultSet resultSet = statement.getResultSet()) {
                    if (resultSet.next()) {
                        int orderShopID = resultSet.getInt("orderShopID");
                        String status = resultSet.getString("status");
                        double shopOrderPrice = resultSet.getDouble("shopOrderPrice");
                        String address = resultSet.getString("address");
                        String phone = resultSet.getString("phone");
                        Integer shipperID = resultSet.getInt("ShipperID");
                        return new orderShop(orderShopID, shopID, status, BigDecimal.valueOf(shopOrderPrice), address, phone, shipperID);
                    }
                }
            }

        }

        return null;
    }

    public List<orderShop> getOrderShopsByShopID(int shopID) {
        String query = "SELECT * FROM OrderShop WHERE shopID = ?";
        List<orderShop> orderShops = new ArrayList<>();

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, shopID);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int orderShopID = resultSet.getInt("orderShopID");
                    String status = resultSet.getString("status");
                    double shopOrderPrice = resultSet.getDouble("shopOrderPrice");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    Integer shipperID = resultSet.getInt("shipperID");

                    orderShop orderShop = new orderShop(orderShopID, shopID, status, BigDecimal.valueOf(shopOrderPrice), address, phone, shipperID);
                    orderShops.add(orderShop);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return orderShops;
    }

    public void updateShipperID(int orderShopID, int shipperID) throws SQLException {
        String query = "UPDATE OderShop SET ShipperID = ? WHERE orderShopID = ?";
        try (Connection connection = DriverManager.getConnection(url, userId, passWord);
                PreparedStatement preparedStatement = connection.prepareStatement(query);){
            
            preparedStatement.setInt(1, shipperID);
            preparedStatement.setInt(2, orderShopID);

            preparedStatement.executeUpdate();
        } 
    }
}
