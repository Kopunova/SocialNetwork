package ua.com.kopunova;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    public Connection getConnection() throws SQLException;

    public UserDao getUserDao(Connection connection);

    public UserNewsDao getUserNewsDao(Connection connection);

    public NewsDao getNewsDao(Connection connection);

    public NewsCommentDao getNewsCommentDao(Connection connection);

}
