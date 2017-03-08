package ua.com.kopunova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlNewsDao implements NewsDao {
    private final Connection connection;

    @Override
    public News getNewsById(int newsId) throws SQLException {

        String sql = "SELECT * FROM news WHERE id = ?;";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, newsId);

        ResultSet rs = stm.executeQuery();
        rs.next();
        News n = new News();
        n.setId(rs.getInt("id"));
        n.setCreated(rs.getString("created"));
        n.setUserId(rs.getInt("user_id"));
        n.setContent(rs.getString("content"));
        n.setMediaFile(rs.getString("media_file"));
        return n;
    }

    public PostgreSqlNewsDao(Connection connection) {
        this.connection = connection;
    }
}




























