package com.erpsystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 29.11.2014.
 */
public class DatabaseManager {

    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String SCHEMA_NAME = "ArtushevskayaDB";

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://" + HOST + ":" + PORT + "/" + SCHEMA_NAME;
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getDBConnection() {
        try {
            Class.forName(DB_DRIVER).newInstance();
            return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
