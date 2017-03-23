package ua.com.kopunova.impl;

import ua.com.kopunova.DBException;
import ua.com.kopunova.News;
import ua.com.kopunova.NewsDao;
import ua.com.kopunova.NewsService;

public class NewsServiceImpl implements NewsService {

    NewsDao newsDao = new NewsDaoImpl();

    @Override
    public News getNewsById(int newsId) throws DBException {
        return newsDao.getNewsById(newsId);
    }

}





























