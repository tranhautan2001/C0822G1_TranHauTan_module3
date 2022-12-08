package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
   IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> selectEmployee() throws SQLException {
        return iEmployeeRepository.selectEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return iEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        iEmployeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        return iEmployeeRepository.searchByName(name);
    }


}
