package ua.com.kopunova;

import java.sql.SQLException;

public interface NewsDao {

    public News getNewsById(int newsId) throws DBException;

}
