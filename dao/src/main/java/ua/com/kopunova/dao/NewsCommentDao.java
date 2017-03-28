package ua.com.kopunova.dao;

import ua.com.kopunova.model.NewsComment;

import java.util.List;

public interface NewsCommentDao {

    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException;

}
