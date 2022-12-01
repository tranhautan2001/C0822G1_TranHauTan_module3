package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    @Override
    public List<Customer> selectCustomer() {
        return iCustomerRepository.selectCustomer();
    }

    @Override
    public boolean delete(int id_customer) {
        return iCustomerRepository.delete(id_customer);
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        iCustomerRepository.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id_customer) {
        return iCustomerRepository.selectCustomer(id_customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerRepository.searchByName(name);
    }


}
