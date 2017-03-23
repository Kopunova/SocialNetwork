package ua.com.kopunova.impl;

import ua.com.kopunova.DBException;
import ua.com.kopunova.User;
import ua.com.kopunova.UserDao;
import ua.com.kopunova.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User getUserById(int id) throws DBException {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws DBException {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getUserFriends(int id) throws DBException {
        return userDao.getUserFriends(id);
    }

    @Override
    public void insertUser(User user) throws DBException {
        userDao.insertUser(user);
    }
}






















