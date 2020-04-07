/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql.dao;

import java.sql.*;

/**
 *
 * @author home-pc
 */
public class Database {
     private static final String URL = "jdbc:mysql://localhost:3306/musicalbums";
    private static final String USER = "dba";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;

    private static Database databaseInstance = new Database();

    public static Database getInstance() {
        return databaseInstance;
    }

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
