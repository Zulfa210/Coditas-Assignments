package ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zulfa Attar
 */
public class ConnectionMaker implements ConnectionParameters{
    static Connection connection = null;
    private ConnectionMaker(){

    }

    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName(ConnectionParameters.className);
                connection = DriverManager.getConnection(ConnectionParameters.url, ConnectionParameters.userName, ConnectionParameters.password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
