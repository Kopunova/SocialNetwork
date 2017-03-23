package ua.com.kopunova;

import java.util.List;

public interface NewsCommentService {

    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException;
}
