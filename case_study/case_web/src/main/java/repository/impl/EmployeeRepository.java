package repository.impl;

import model.Employee;
import model.Facility;
import repository.IEmployeeRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_EMPLOYEE = "select * from employee \n" +
            "join positions on positions.id_position = employee.id_position\n" +
            "join education_degree on education_degree.id_education_degree = employee.id_education_degree\n" +
            "join division on division.id_division = employee.id_division;";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?";
    private static final String ADD_EMPLOYEE ="insert into employee(id, name, data_of_birth, id_card, salary, phone_number,email,address, id_position, id_education_degree, id_division) values (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE = "update employee set name =?,data_of_birth=?, id_card=?, salary=?,phone_number=?, email=?,address=?, id_position=?,id_education_degree=?,id_division=? where id=?";
  private static final String SEARCH_EMPLOYEE_BY_NAME ="select * from employee \n" +
          "join positions on positions.id_position = employee.id_position \n" +
          "join education_degree on education_degree.id_education_degree = employee.id_education_degree\n" +
          "join division on division.id_division = employee.id_division " +
          "where name like ?;";

    @Override
    public List<Employee> selectEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = connection.prepareStatement(SELECT_EMPLOYEE);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String dateOfBirth = resultSet.getString("data_of_birth");
            String idCard = resultSet.getString("id_card");
            double salary = resultSet.getDouble("salary");
            String phoneNumber = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String namePosition = resultSet.getString("name_position");
            String nameEducationDegree = resultSet.getString("name_education_degree");
            String nameDivision = resultSet.getString("name_division");
            employeeList.add(new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, namePosition, nameEducationDegree, nameDivision));
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE);
            ps.setInt(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addEmployee(Employee employee) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_EMPLOYEE);
            ps.setInt(1,employee.getId());
            ps.setString(2,employee.getName());
            ps.setString(3,employee.getDateOfBirth());
            ps.setString(4,employee.getIdCard());
            ps.setDouble(5,employee.getSalary());
            ps.setString(6,employee.getPhoneNumber());
            ps.setString(7,employee.getEmail());
            ps.setString(8,employee.getAddress());
            ps.setString(9,employee.getNamePosition());
            ps.setString(10,employee.getNameEducationDegree());
            ps.setString(11,employee.getNameDivision());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        boolean rowUpdated = false;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            ps.setString(1,employee.getName());
            ps.setString(2,employee.getDateOfBirth());
            ps.setString(3,employee.getIdCard());
            ps.setDouble(4,employee.getSalary());
            ps.setString(5,employee.getPhoneNumber());
            ps.setString(6,employee.getEmail());
            ps.setString(7,employee.getAddress());
            ps.setString(8,employee.getNamePosition());
            ps.setString(9,employee.getNameEducationDegree());
            ps.setString(10,employee.getNameDivision());
            ps.setInt(11,employee.getId());
            rowUpdated = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
        statement.setString(1, "%" + name + "%");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nameOne = rs.getString("name");
            String dateOfBirth = rs.getString("data_of_birth");
            String idCard = rs.getString("id_card");
            double salary = rs.getDouble("salary");
            String phoneNumber = rs.getString("phone_number");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String namePosition = rs.getString("name_position");
            String nameEducationDegree = rs.getString("name_education_degree");
            String nameDivision = rs.getString("name_division");
            employeeList.add(new Employee(id, nameOne, dateOfBirth, idCard, salary, phoneNumber, email, address, namePosition, nameEducationDegree, nameDivision));
        }
        return employeeList;
    }
}
