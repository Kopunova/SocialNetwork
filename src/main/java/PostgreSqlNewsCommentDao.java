package ua.com.kopunova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlNewsCommentDao implements NewsCommentDao {
    private final Connection connection;

    @Override
    public List<NewsComment> getAllNewsComments(int userNewsId) throws SQLException {
        String sql = "SELECT * FROM news_comment WHERE user_news_id = ? ORDER BY created;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, userNewsId);
        ResultSet rs = stm.executeQuery();
        List<NewsComment> list = new ArrayList<NewsComment>();
        while (rs.next()) {
            NewsComment c = new NewsComment();
            c.setId(rs.getInt("id"));
            c.setCreated(rs.getString("created"));
            c.setUserNewsId(rs.getString("user_news_id"));
            c.setUserId(rs.getString("user_id"));
            c.setContent(rs.getString("content"));
            list.add(c);
        }
        return list;
    }

    public PostgreSqlNewsCommentDao(Connection connection) {
        this.connection = connection;
    }
}
