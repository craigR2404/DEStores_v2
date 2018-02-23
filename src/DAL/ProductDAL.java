package DAL;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAL {

    private Connection connection;

    public ProductDAL() {
        try {
            connection = ConnectionYo.GetConnection();
        } catch (Exception e) {

        }
    }


    public List<Product> getAllProducts() {
        String query = "SELECT * FROM products";
        List<Product> products = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Integer stockLevel = resultSet.getInt("stockLevel");
                Double price = resultSet.getDouble("price");
                String promotion = resultSet.getString("promotion");
                Product product = new Product(id,name,stockLevel,price,promotion);
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addProduct(Product prod){
        String query = "INSERT INTO products(name, stockLevel, price, promotion) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, prod.getName());
            preparedStatement.setInt(2, prod.getStockLevel());
            preparedStatement.setDouble(3, prod.getPrice());
            preparedStatement.setString(4, prod.getPromotion());
            preparedStatement.execute();
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
