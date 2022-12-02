package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
       private static final String SELECT_ALL = "select * from customer \n" +
               "join customer_type on customer.id_customer_type = customer_type.id_customer_type;";
       private static final String DELETE_BY_ID = "delete from customer where id_customer = ?";
    private static final String ADD_CUSTOMER_SQL = "insert into customer (id_customer,id_customer_type,name, date_of_birth,gender,id_card,phone_number,email,address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set id_customer_type =?,name =?,date_of_birth =?,gender =?,id_card =?,phone_number=?,email=?,address=? where id_customer =?;";


    @Override
    public List<Customer> selectCustomer() {
       List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("id_customer");
               String name = resultSet.getString("name");
               String date_of_birth = resultSet.getString("date_of_birth");
               String gender = resultSet.getString("gender");
               int id_card = resultSet.getInt("id_card");
               int phone_number = resultSet.getInt("phone_number");
               String email = resultSet.getString("email");
               String address = resultSet.getString("address");
               String name_customer_type = resultSet.getString("name_customer_type");
               customerList.add(new Customer(id,name,date_of_birth,gender,id_card,phone_number,email,address,name_customer_type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean delete(int id_customer) {
       Connection connection = BaseRepository.getConnectDB();
       try {
           PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
           ps.setInt(1,id_customer);
           return ps.executeUpdate()>0;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        System.out.println(ADD_CUSTOMER_SQL);
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(ADD_CUSTOMER_SQL)) {
            statement.setInt(1,customer.getId());
            statement.setInt(2,customer.getId_customer_type());
            statement.setString(3,customer.getName());
            statement.setString(4,customer.getDate_of_birth());
            statement.setString(5,customer.getGender());
            statement.setInt(6,customer.getId_card());
            statement.setInt(7,customer.getPhone_number());
            statement.setString(8,customer.getEmail());
            statement.setString(9,customer.getAddress());
            System.out.println(statement);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
    boolean rowUpdated = false;
    Connection connection = BaseRepository.getConnectDB();
    PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
        statement.setInt(1,customer.getId_customer_type());
        statement.setString(2,customer.getName());
        statement.setString(3,customer.getDate_of_birth());
        statement.setString(4,customer.getGender());
        statement.setInt(5,customer.getId_card());
        statement.setInt(6,customer.getPhone_number());
        statement.setString(7,customer.getEmail());
        statement.setString(8,customer.getAddress());
        statement.setInt(9,customer.getId());
        rowUpdated = statement.executeUpdate()>0;
        return rowUpdated;
    }

    @Override
    public Customer selectCustomer(int id_customer) {
        return null;
    }

    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }

}
