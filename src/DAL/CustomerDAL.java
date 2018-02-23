
package DAL;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAL {

    private Connection connection;

    public CustomerDAL(){
        try{
            connection = ConnectionYo.GetConnection();
        }catch (Exception e){

        }
    }

    public List<Customer> getAllCustomers(){
        String query = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String nameYo = resultSet.getString("nameYo");
                String surnameYo = resultSet.getString("surnameYo");
                String emailYo = resultSet.getString("emailYo");
                Double creditYo = resultSet.getDouble("creditYo");
                Customer customer = new Customer(id, nameYo, surnameYo, emailYo,creditYo);
                customers.add(customer);

            }
            return customers;
        }catch (Exception e){
            return null;
        }
    }



    public boolean addCustomer(Customer cust){
        String query = "INSERT INTO customer(nameYo, surnameYo, emailYo, creditYo) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,cust.getNameYo());
            preparedStatement.setString(2,cust.getSurnameYo());
            preparedStatement.setString(3,cust.getEmailYo());
            preparedStatement.setDouble(4,cust.getCreditYo());
            preparedStatement.execute();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}

