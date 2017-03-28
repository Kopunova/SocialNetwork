package ua.com.kopunova.dao.impl;

import ua.com.kopunova.dao.DBException;
import ua.com.kopunova.dao.FactoryDao;
import ua.com.kopunova.dao.NewsDao;
import ua.com.kopunova.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsDaoImpl implements NewsDao {

    public News getNewsById(int newsId) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        News news = null;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM news WHERE id = ?;";
            stm = conn.prepareStatement(sql);

            stm.setInt(1, newsId);

            rs = stm.executeQuery();
            rs.next();
            news = new News();
            news.setId(rs.getInt("id"));
            news.setCreated(rs.getString("created"));
            news.setUserId(rs.getInt("user_id"));
            news.setContent(rs.getString("content"));
            news.setMediaFile(rs.getString("media_file"));
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getNewsById()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return news;
    }
}




























