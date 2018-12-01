//package sqlite_databases;
//
//import models.InfoPerson;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class SqliteConnection {
//    private Connection connection = null;
//    private String url = "jdbc:sqlite:personal_information.db";
//    private String className = "org.sqlite.JDBC";
//
//    public Connection connect(){
//        try{
//            Class.forName(className);
//            this.connection = DriverManager.getConnection(url);
//            if (!connection.isClosed()){
//                System.out.println("connect");
//            } else{
//                System.out.println("failed");
//            }
//        } catch (ClassNotFoundException | SQLException e){
//            System.err.println("can't connect");
//        }
//        return connection;
//    }
//
//    public void insert(String date, String title, String name, String surname, String address, String mobile){
//        try{
//            Class.forName(className);
//            this.connection = DriverManager.getConnection(url);
//            if (connection != null){
//                String query = "insert into personal_information values (\'"+date+"\', \'"+title+"\', \'"+name+"\', \'"+surname+"\', \'"+address+"\', \'"+mobile+"\')";
//                PreparedStatement p = connection.prepareStatement(query); //ใส่ข้อมูลลงไปในฐานข้อมูล
//                p.executeUpdate();
//                System.out.println(11111);
//            } else {
//                System.out.println(22222);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Connection to database has problem");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<InfoPerson> load(){
//        ArrayList<InfoPerson> info = new ArrayList();
//        try{
//            Class.forName(className);
//            this.connection = DriverManager.getConnection(url);
//            if (connection != null){
//                Statement statement = connection.createStatement();
//                String query = "select * from personal_information";
//                ResultSet resultSet = statement.executeQuery(query);
//                while(resultSet.next()){
//                    String date = resultSet.getString(1);
//                    String title = resultSet.getString(2);
//                    String name = resultSet.getString(3);
//                    String surname = resultSet.getString(4);
//                    String address = resultSet.getString(5);
//                    String mobile = resultSet.getString(6);
//                    info.add(new InfoPerson(date,title,name,surname,address,mobile));
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return info;
//    }
//}
