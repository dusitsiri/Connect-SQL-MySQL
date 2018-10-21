package sqlserver_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    private Connection connection;
    private static final String URL = "jdbc:sqlserver://localhost:3308/master";

    public Connection connection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(URL);
            if (!this.connection.isClosed()){
                System.out.println("SQLite connected successful");
            }else {
                System.out.println("SQLite connect failed");
            }
        }catch (SQLException e){
            System.err.println("SQLite connect failed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.connection;
    }
}
