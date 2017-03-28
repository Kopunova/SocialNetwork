package ua.com.kopunova.service;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.UserNews;

import java.util.List;

public interface UserNewsService {

    public List<UserNews> getAllUserNews(int userId) throws DBException;

    public void insertUserNews(UserNews userNews) throws DBException;

    public void deleteUserNews(UserNews userNews) throws DBException;

}
