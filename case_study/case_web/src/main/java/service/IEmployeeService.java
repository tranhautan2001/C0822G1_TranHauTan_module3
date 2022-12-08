package service;

import model.Employee;


import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectEmployee() throws SQLException;
    boolean deleteEmployee(int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> searchByName(String name) throws SQLException;

}
