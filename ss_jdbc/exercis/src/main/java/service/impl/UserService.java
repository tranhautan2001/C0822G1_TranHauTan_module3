package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
IUserRepository iUserRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) throws SQLException {
        return iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        iUserRepository.deleteUser(id);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        iUserRepository.updateUser(user);
    }

    @Override
    public List<User> findByCountry(String country) throws SQLException {
        return iUserRepository.findByCountry(country);
    }

}
