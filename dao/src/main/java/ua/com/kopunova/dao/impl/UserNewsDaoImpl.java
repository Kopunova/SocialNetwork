package ua.com.kopunova.dao.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.FactoryDao;
import ua.com.kopunova.dao.UserNewsDao;
import ua.com.kopunova.model.UserNews;
import ua.com.kopunova.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserNewsDaoImpl implements UserNewsDao {

    public List<UserNews> getAllUserNews(int userId) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<UserNews> list;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM user_news WHERE user_id = ? ORDER BY created DESC;";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, userId);
            rs = stm.executeQuery();
            list = new ArrayList<UserNews>();
            while (rs.next()) {
                UserNews user = new UserNews();
                user.setId(rs.getInt("id"));
                user.setUserId(rs.getInt("user_id"));
                user.setNewsId(rs.getInt("news_id"));
                user.setCreated(rs.getString("created"));
                user.setLikes(rs.getInt("likes"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getAllUserNews()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return list;
    }

    public void insertUserNews(UserNews userNews) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        String sql = "";

        try {
            conn.setAutoCommit(false);
        } catch(SQLException e) {
            throw new DBException("Can't set auto-commit mode.");
        }

        try {
            News news = userNews.getNews();
            sql = "INSERT INTO news VALUES(DEFAULT, DEFAULT, ?, ?, ?)";
            stm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1, news.getUserId());
            stm.setString(2, news.getContent());
            stm.setString(3, news.getMediaFile());
            stm.executeUpdate();
            rs = stm.getGeneratedKeys();
            if (rs.next()){
                int newsId = rs.getInt(1);
                sql = "INSERT INTO user_news VALUES(DEFAULT, ?, ?, DEFAULT, ?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, userNews.getUserId());
                stm.setInt(2, newsId);
                stm.setInt(3, userNews.getLikes());
                stm.execute();
                conn.commit();
            } else {
                try {
                    conn.rollback();
                } catch(SQLException e) {
                    throw new DBException("Can't rollback a transaction");
                }
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch(SQLException ex) {
                throw new DBException("Can't rollback a transaction");
            }
            throw new DBException("Can't execute SQL: insertUserNews()" + sql);
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
    }

    public void deleteUserNews(UserNews userNews) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        String sql = "";

        try {
            sql = "DELETE FROM user_news WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, userNews.getId());
            stm.execute();
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: deleteUserNews()" + sql);
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
        }
    }
}























