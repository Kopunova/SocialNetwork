package ua.com.kopunova.impl;

import ua.com.kopunova.DBException;
import ua.com.kopunova.NewsComment;
import ua.com.kopunova.NewsCommentDao;
import ua.com.kopunova.NewsCommentService;

import java.util.List;

public class NewsCommentServiceImpl implements NewsCommentService {

    NewsCommentDao newsCommentDao = new NewsCommentDaoImpl();

    @Override
    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException {
        return newsCommentDao.getAllNewsComments(userNewsId);
    }
}
