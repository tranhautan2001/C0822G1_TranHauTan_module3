package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void insertUser(User user) throws SQLException;
    User selectUser(int id) throws SQLException;

    List<User> selectAllUsers() throws SQLException;

    void deleteUser(int id) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<User> findByCountry(String country) throws SQLException;


}
