package ua.com.kopunova.service.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.impl.NewsCommentDaoImpl;
import ua.com.kopunova.model.NewsComment;
import ua.com.kopunova.dao.NewsCommentDao;
import ua.com.kopunova.service.NewsCommentService;

import java.util.List;

public class NewsCommentServiceImpl implements NewsCommentService {

    NewsCommentDao newsCommentDao = new NewsCommentDaoImpl();

    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException {
        return newsCommentDao.getAllNewsComments(userNewsId);
    }
}
