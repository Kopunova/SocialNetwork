package ua.com.kopunova.service;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.User;

import java.util.List;

public interface UserService {

    public User checkUser(User user) throws DBException;

    public User getUserById(int id) throws DBException;

    public List<User> getAllUsers() throws DBException;

    public List<User> getUserFriends(int id) throws DBException;

    public void insertUser(User user) throws DBException;

}
