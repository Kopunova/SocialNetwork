package ua.com.kopunova;

import java.util.List;

public interface UserService {

    public User getUserById(int id) throws DBException;

    public List<User> getAllUsers() throws DBException;

    public List<User> getUserFriends(int id) throws DBException;

    public void insertUser(User user) throws DBException;

}
