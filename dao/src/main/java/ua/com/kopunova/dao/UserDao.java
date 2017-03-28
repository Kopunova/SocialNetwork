package ua.com.kopunova.dao;

import ua.com.kopunova.model.User;

import java.util.List;

public interface UserDao {

    public User checkUser(User user) throws DBException;

    public User getUserById(int id) throws DBException;

    public List<User> getAllUsers() throws DBException;

    public List<User> getUserFriends(int id) throws DBException;

    public void insertUser(User u) throws DBException;

}