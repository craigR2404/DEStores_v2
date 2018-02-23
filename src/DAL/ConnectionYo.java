
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionYo {
        public static Connection GetConnection() throws Exception{
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            String serverName = "localhost";
            String myDatabase = "honsdb";
            String url = "jdbc:mysql://" + serverName + "/" + myDatabase;

            String user = "root";
            String password = "password";
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        }
    }


