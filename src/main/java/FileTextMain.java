//import models.Vocabulary;
//import sqlite_database.SqliteConnection;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//
//public class FileTextMain {
//    private static SqliteConnection sqliteConnection = new SqliteConnection();
//    private static Connection connection = sqliteConnection.connect();
//
//    public static void main(String[] args) {
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("vocabulary.txt"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] vocabulary = line.split(" ");
//                String word = vocabulary[0];
//                String meaning = vocabulary[1];
//                sqliteConnection.insert(word, meaning);
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.err.println("Cannot open file");
//        }
//    }
//}
