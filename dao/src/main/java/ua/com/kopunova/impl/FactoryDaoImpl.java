package ua.com.kopunova.impl;

import ua.com.kopunova.FactoryDao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDaoImpl implements FactoryDao {
    private String user = "postgres";
    private String password = "1111";
    private String url = "jdbc:postgresql://localhost/social_network";
    private String driver = "org.postgresql.Driver";

    FactoryDaoImpl() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection conn) {
        if (conn != null)
            try { conn.close(); }
            catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void closeStatement(PreparedStatement stm) {
        if (stm != null)
            try { stm.close(); }
            catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void closeResultSet(ResultSet rs) {
        if (rs != null)
            try { rs.close(); }
            catch (SQLException e) { e.printStackTrace(); }

    }
}






















