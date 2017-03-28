package ua.com.kopunova.service.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.impl.UserNewsDaoImpl;
import ua.com.kopunova.model.UserNews;
import ua.com.kopunova.dao.UserNewsDao;
import ua.com.kopunova.service.UserNewsService;

import java.util.List;

public class UserNewsServiceImpl implements UserNewsService {

    UserNewsDao userNewsDao = new UserNewsDaoImpl();

    public List<UserNews> getAllUserNews(int userId) throws DBException {
        return userNewsDao.getAllUserNews(userId);
    }

    public void insertUserNews(UserNews userNews) throws DBException {
        userNewsDao.insertUserNews(userNews);
    }

    public void deleteUserNews(UserNews userNews) throws DBException {
        userNewsDao.deleteUserNews(userNews);
    }
}

























