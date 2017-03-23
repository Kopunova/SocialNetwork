package ua.com.kopunova.impl;

import ua.com.kopunova.DBException;
import ua.com.kopunova.FactoryDao;
import ua.com.kopunova.NewsComment;
import ua.com.kopunova.NewsCommentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsCommentDaoImpl implements NewsCommentDao {

    @Override
    public List<NewsComment> getAllNewsComments(int userNewsId) throws DBException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<NewsComment> list;

        FactoryDao daoFactory = new FactoryDaoImpl();
        conn = daoFactory.getConnection();

        try {
            String sql = "SELECT * FROM news_comment WHERE user_news_id = ? ORDER BY created;";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, userNewsId);
            rs = stm.executeQuery();
            list = new ArrayList<NewsComment>();
            while (rs.next()) {
                NewsComment newsComment = new NewsComment();
                newsComment.setId(rs.getInt("id"));
                newsComment.setCreated(rs.getString("created"));
                newsComment.setUserNewsId(rs.getString("user_news_id"));
                newsComment.setUserId(rs.getString("user_id"));
                newsComment.setContent(rs.getString("content"));
                list.add(newsComment);
            }
        } catch (SQLException e) {
            throw new DBException("Can't execute SQL: getAllNewsComments()");
        } finally {
            daoFactory.closeConnection(conn);
            daoFactory.closeStatement(stm);
            daoFactory.closeResultSet(rs);
        }
        return list;
    }
}





















