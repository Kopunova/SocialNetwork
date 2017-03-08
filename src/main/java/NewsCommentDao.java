package ua.com.kopunova;

import java.sql.SQLException;
import java.util.List;

public interface NewsCommentDao {

    public List<NewsComment> getAllNewsComments(int userNewsId) throws SQLException;

}
