package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    List<Customer> selectCustomer();

    boolean delete(int id_customer);

    void addCustomer(Customer customer)throws SQLException;

    void updateCustomer(Customer customer) throws SQLException;

    Customer selectCustomer(int id_customer);

    List<Customer> searchByName(String name);
}
