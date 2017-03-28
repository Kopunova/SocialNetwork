package ua.com.kopunova.dao;

import ua.com.kopunova.model.UserNews;

import java.util.List;

public interface UserNewsDao {

    public List<UserNews> getAllUserNews(int userId) throws DBException;

    public void insertUserNews(UserNews userNews) throws DBException;

    public void deleteUserNews(UserNews userNews) throws DBException;

}
