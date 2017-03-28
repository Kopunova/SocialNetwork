package ua.com.kopunova.dao.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.FactoryDao;
import ua.com.kopunova.dao.UserDao;
import ua.com.kopunova.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User checkUser(User user) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        User registeredUser = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM users WHERE email = ?;";
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getEmail());

            rs = stm.executeQuery();
            if (rs.next()) {
                registeredUser = new User();
                registeredUser.setId(rs.getInt("id"));
                registeredUser.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: checkUser()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return registeredUser;
    }

    public User getUserById(int id) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        User user = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM users WHERE id = ?;";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);

            rs = stm.executeQuery();
            rs.next();
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getUserById()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return user;
    }

    public List<User> getAllUsers() throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<User> list;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM users;";

            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            list = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setMediaFile(rs.getString("media_file"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getAllUsers()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return list;
    }

    public List<User> getUserFriends(int id) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<User> list;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM user_friend WHERE user_id = ?;";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            list = new ArrayList<User>();
            while (rs.next()) {
                User user = getUserById(rs.getInt("friend_user_id"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getAllUsers()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return list;
    }

    public void insertUser(User user) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "INSERT INTO users VALUES( DEFAULT,  ?,  ?,  ?,  ?)";

            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getPassword());
            stm.setString(4, user.getMediaFile());
            stm.execute();
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: insertUser()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
    }
}






























