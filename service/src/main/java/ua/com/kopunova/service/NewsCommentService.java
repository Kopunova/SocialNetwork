package ua.com.kopunova.service;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.model.NewsComment;

import java.util.List;

public interface NewsCommentService {

    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException;
}
