package ua.com.kopunova;

import java.sql.SQLException;
import java.util.List;

public interface UserNewsDao {

    public List<UserNews> getAllUserNews(int userId) throws SQLException;

}
