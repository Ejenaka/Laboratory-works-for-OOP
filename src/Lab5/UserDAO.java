package Lab5;

import Lab3.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    private Connection connection;

    public UserDAO() {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create(User entity) {
        String query = "INSERT INTO Users VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getUsername());
            preparedStatement.setString(3, entity.getPassword());

            ResultSet result = preparedStatement.getGeneratedKeys();
            entity.setId(result.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public boolean update(User entity) {
        boolean result = false;
        String query = "UPDATE Users SET name = ?, username = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getUsername());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setInt(4, entity.getId());

            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM Users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User findById(int id) {
        User foundUser = null;
        String query = "SELECT * FROM Users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            String name = resultSet.getString("name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            foundUser = new User(name, username, password) {};
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundUser;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
