package ua.com.kopunova;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public void insertUser(User u) throws SQLException;

    public User getUserById(int id) throws SQLException;

    public List<User> getAllUsers() throws SQLException;

    public List<User> getUserFriends(int id) throws SQLException;

}