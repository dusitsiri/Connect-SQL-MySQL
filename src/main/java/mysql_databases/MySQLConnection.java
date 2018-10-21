package mysql_databases;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class MySQLConnection {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3307/productdate";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection connection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!this.connection.isClosed()){
                System.out.println("MySQL connected successful");
            } else{
                System.out.println("MySQL connect failed");
            }
        }catch (ClassNotFoundException | SQLException e){
            System.err.println("MySQL connect failed");
        }
        return this.connection;
    }

    public int getMaxId(){
        int maxId = 0;
        try{
            Statement statement = connection.createStatement();
            String query = "select max(id) from product";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                maxId = resultSet.getInt(1);
                return maxId;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 1;
    }

    public void insertDateTime(int id, LocalDate date, LocalTime time){
        try {
            Statement statement = connection.createStatement();
            String query = "insert into product(id, date, date_time) values (\'"+id+"\', \'"+date+"\', \'"+time+"\')";
            statement.executeUpdate(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<LocalDateTime> loadDateTime(){
        ArrayList<LocalDateTime> dateTimes = new ArrayList<>();
        LocalDateTime localDateTime = null;
        try{
            Statement statement = connection.createStatement();
            String query = "select * from product";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("date_time");
                localDateTime = LocalDateTime.parse(date.toString()+"T"+time.toString());
                dateTimes.add(localDateTime);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dateTimes;
    }

    public void timeDiff(LocalDateTime time1, LocalDateTime time2){
//        try{
//
//        } catch (){
//
//        }
    }

}
