package mysql_databases;

import mysql_databases.MySQLConnection;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MySQLMain {
    public static void main(String[] args) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        Connection connection = mySQLConnection.connection();

        //Parse Localdate and LocalTime to LocalDateTime
        LocalDateTime time1 = LocalDateTime.now();
//        System.out.println("True: " + time1);
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
//        LocalDateTime time2 = LocalDateTime.parse(date.toString()+"T"+time.toString());
//        System.out.println("Expect: "+ time2);

        mySQLConnection.insertDateTime(mySQLConnection.getMaxId()+1, time1.toLocalDate(), time1.toLocalTime());

        //load All dateTimes
        ArrayList<LocalDateTime> dateTimes = mySQLConnection.loadDateTime();
        for (LocalDateTime localDateTime: dateTimes){
            System.out.println(localDateTime);
        }

    }
}
