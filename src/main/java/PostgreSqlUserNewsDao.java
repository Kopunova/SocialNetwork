package ua.com.kopunova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlUserNewsDao implements UserNewsDao {
    private final Connection connection;

    @Override
    public List<UserNews> getAllUserNews(int userId) throws SQLException {
        String sql = "SELECT * FROM user_news WHERE user_id = ? ORDER BY created DESC;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, userId);
        ResultSet rs = stm.executeQuery();
        List<UserNews> list = new ArrayList<UserNews>();
        while (rs.next()) {
            UserNews u = new UserNews();
            u.setId(rs.getInt("id"));
            u.setUserId(rs.getString("user_id"));
            u.setNewsId(rs.getInt("news_id"));
            u.setCreated(rs.getString("created"));
            u.setLikes(rs.getInt("likes"));
            list.add(u);
        }
        return list;
    }

    public PostgreSqlUserNewsDao(Connection connection) {
        this.connection = connection;
    }
}
