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
       private static final String SELECT_ALL = "select * from customer";
       private static final String DELETE_BY_ID = "delete from customer where id_customer = ?";


    @Override
    public List<Customer> selectCustomer() {
       List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("id_customer");
               int id_customer_type = resultSet.getInt("id_customer_type");
               String name = resultSet.getString("name");
               String date_of_birth = resultSet.getString("date_of_birth");
               String gender = resultSet.getString("gender");
               int id_card = resultSet.getInt("id_card");
               int phone_number = resultSet.getInt("phone_number");
               String email = resultSet.getString("email");
               String address = resultSet.getString("address");
               customerList.add(new Customer(id,id_customer_type,name,date_of_birth,gender,id_card,phone_number,email,address));
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
}