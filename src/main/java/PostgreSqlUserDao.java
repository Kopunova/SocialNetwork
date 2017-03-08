package ua.com.kopunova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlUserDao implements UserDao {
    private final Connection connection;

    @Override
    public void insertUser(User u) throws SQLException {
        PreparedStatement sql = connection.prepareStatement("INSERT INTO users VALUES( DEFAULT,  ?,  ?,  ?,  ?)");
        sql.setString(1, u.getName());
        sql.setString(2, u.getEmail());
        sql.setString(3, u.getPassword());
        sql.setString(4, u.getMediaFile());
        sql.execute();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, id);

        ResultSet rs = stm.executeQuery();
        rs.next();
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        return u;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setMediaFile(rs.getString("media_file"));
            list.add(u);
        }
        return list;
    }

    @Override
    public List<User> getUserFriends(int id) throws SQLException {
        String sql = "SELECT * FROM user_friend WHERE user_id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            User u = getUserById(rs.getInt("friend_user_id"));
            list.add(u);
        }
        return list;
    }

    public PostgreSqlUserDao(Connection connection) {
        this.connection = connection;
    }
}






























