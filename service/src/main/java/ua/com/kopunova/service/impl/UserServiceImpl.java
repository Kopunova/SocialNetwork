package ua.com.kopunova.service.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.impl.UserDaoImpl;
import ua.com.kopunova.model.User;
import ua.com.kopunova.dao.UserDao;
import ua.com.kopunova.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public User checkUser(User user) throws DBException {
        return userDao.checkUser(user);
    }

    public User getUserById(int id) throws DBException {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() throws DBException {
        return userDao.getAllUsers();
    }

    public List<User> getUserFriends(int id) throws DBException {
        return userDao.getUserFriends(id);
    }

    public void insertUser(User user) throws DBException {
        userDao.insertUser(user);
    }
}






















