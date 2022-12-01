package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> selectCustomer();
    boolean delete(int id_customer);


}
