package ua.com.kopunova.service.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.impl.NewsDaoImpl;
import ua.com.kopunova.model.News;
import ua.com.kopunova.dao.NewsDao;
import ua.com.kopunova.service.NewsService;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    public News getNewsById(int newsId) throws DBException {
        return newsDao.getNewsById(newsId);
    }

}





























