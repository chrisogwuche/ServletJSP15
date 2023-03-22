package com.example.servletjsp15.DAO;

import com.example.servletjsp15.Config.DatabaseConfig;
import com.example.servletjsp15.Model.Reciept;
import com.example.servletjsp15.Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupDOA {

    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    public signupDOA() {
        DatabaseConfig databaseConfig =  new DatabaseConfig();
        this.jdbcUrl = databaseConfig.getJdbcUrl();
        this.jdbcUsername = databaseConfig.getJdbcUsername();
        this.jdbcPassword = databaseConfig.getJdbcPassword();
    }
    private Connection connection;


    public void setConnection() throws SQLException {
        if (connection==null||connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager
                    .getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
        }
    }


    public void closeConnection() throws SQLException {
        if (!connection.isClosed()||connection!=null){
            connection.close();
        }
    }

    public int signup(User user) throws Exception{
        int count = 0;
        String query = "insert into users(firstname,lastname,password) value(?,?,?)";

        setConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getFirstname());
        preparedStatement.setString(2, user.getLastname());
        preparedStatement.setString(3, user.getPassword());
        count = preparedStatement.executeUpdate();//difference between executeUpdate() and executeQuery()
        preparedStatement.close();
        closeConnection();
        return count;
    }
}
