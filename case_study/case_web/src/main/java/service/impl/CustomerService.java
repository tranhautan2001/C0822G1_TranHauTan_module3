package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

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
}
