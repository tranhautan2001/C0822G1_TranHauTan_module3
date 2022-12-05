package repository.impl;

import model.User;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    /*private static final String SELECT_ALL_USERS = "select * from users";*/
    /*private static final String DELETE_USERS_SQL = "delete from users where id = ?;";*/
    /*private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";*/
    private static final String SEARCH_USER = " select * from users where country =?";

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public User selectUser(int id) throws SQLException {
        User user = null;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            user = new User(id, name, email, country);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException {
        String query ="{CALL display_list_user()}";
        List<User> users = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        CallableStatement callableStatement = connection.prepareCall(query);
        ResultSet rs = callableStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            users.add(new User(id, name, email, country));
        }
        return users;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String queryTow = "{CALL deleteUser(?)}";
        boolean rowDeleted;
        Connection connection = BaseRepository.getConnectDB();
        CallableStatement callableStatement = connection.prepareCall(queryTow);
        callableStatement.setInt(1, id);
        callableStatement.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String queryThree = "{CALL update_info(?,?,?,?)}";
        boolean rowUpdated;
        Connection connection = BaseRepository.getConnectDB();
        CallableStatement callableStatement = connection.prepareCall(queryThree);
        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getEmail());
        callableStatement.setString(3, user.getCountry());
        callableStatement.setInt(4, user.getId());
        rowUpdated = callableStatement.executeUpdate() > 0;
    }

    @Override
    public List<User> findByCountry(String country) throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps = connection.prepareStatement(SEARCH_USER);
        ps.setString(1, country);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String countryOne = rs.getString("country");
            userList.add(new User(id, name, email, countryOne));

        }
        return userList;
    }
}
