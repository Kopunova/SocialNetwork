package ua.com.kopunova.dao;

import ua.com.kopunova.model.News;

public interface NewsDao {

    public News getNewsById(int newsId) throws DBException;

}
