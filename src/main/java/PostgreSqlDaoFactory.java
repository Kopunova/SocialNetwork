package ua.com.kopunova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlDaoFactory implements DaoFactory {

    private String user = "postgres";
    private String password = "1111";
    private String url = "jdbc:postgresql://localhost/social_network";
    private String driver = "org.postgresql.Driver";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public UserDao getUserDao(Connection connection) {return new PostgreSqlUserDao(connection);}
    @Override
    public UserNewsDao getUserNewsDao(Connection connection) {return new PostgreSqlUserNewsDao(connection);}
    @Override
    public NewsDao getNewsDao(Connection connection) {return new PostgreSqlNewsDao(connection);}
    @Override
    public NewsCommentDao getNewsCommentDao(Connection connection) {return new PostgreSqlNewsCommentDao(connection);}

    public PostgreSqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}






















