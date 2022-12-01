package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> selectCustomer();

    boolean delete(int id_customer);
}
