package ConnectionMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zulfa Attar
 */
public class ConnectionMaker implements ConnectionParamters{
    static Connection connection = null;
    private ConnectionMaker(){
    }

    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName(ConnectionParamters.className);
                connection = DriverManager.getConnection(ConnectionParamters.url, ConnectionParamters.userName, ConnectionParamters.password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
