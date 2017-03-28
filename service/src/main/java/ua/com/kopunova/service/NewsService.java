package ua.com.kopunova.service;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.News;

public interface NewsService {

    public News getNewsById(int newsId) throws DBException;

}
