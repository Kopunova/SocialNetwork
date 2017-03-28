package ua.com.kopunova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface FactoryDao {

    public Connection getConnection();

    public void closeResultSet(ResultSet rs);

    public void closeStatement(PreparedStatement stm);

    public void closeConnection(Connection conn);

}
































