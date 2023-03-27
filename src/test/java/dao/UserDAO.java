package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws ClassNotFoundException, SQLException {
       Class.forName("org.postgresql.Driver");
       connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/at", "at", "12345");
       connection.setAutoCommit(true);
    }

    public long saveUser(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?) RETURNING id");
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getEmail());
        ResultSet rs = ps.executeQuery();
        rs.next();
//       ps.close();
        return rs.getLong("id");
    }

    public User getUserById(long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));

        return user;
    }

    public List<User> getUsers() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();

        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            users.add(user);
        }

        return users;
    }
}
