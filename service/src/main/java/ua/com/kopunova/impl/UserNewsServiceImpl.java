package ua.com.kopunova.impl;

import ua.com.kopunova.DBException;
import ua.com.kopunova.UserNews;
import ua.com.kopunova.UserNewsDao;
import ua.com.kopunova.UserNewsService;

import java.util.List;

public class UserNewsServiceImpl implements UserNewsService {

    UserNewsDao userNewsDao = new UserNewsDaoImpl();

    @Override
    public List<UserNews> getAllUserNews(int userId) throws DBException {
        return userNewsDao.getAllUserNews(userId);
    }

    @Override
    public void insertUserNews(UserNews userNews) throws DBException {
        userNewsDao.insertUserNews(userNews);
    }

    @Override
    public void deleteUserNews(UserNews userNews) throws DBException {
        userNewsDao.deleteUserNews(userNews);
    }
}

























