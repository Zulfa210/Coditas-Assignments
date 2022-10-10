package com.example.RestNew.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zulfa Attar
 */
public class ConnectionMaker implements ConnectionParameters {
    static Connection connection = null;

    private ConnectionMaker(){

    }
    public static Connection getConnection() {
        if(connection==null){
            try {
                Class.forName(ConnectionParameters.driverName);
                connection = DriverManager.getConnection(ConnectionParameters.URL,ConnectionParameters.userName,ConnectionParameters.password);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return connection;
    }

}
