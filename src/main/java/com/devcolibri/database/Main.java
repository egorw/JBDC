package com.devcolibri.database;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Driver driver;

        try   {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        }
        catch (SQLException e1) {
            System.out.println("Драйвер не зарегистрировался");
            return;
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
        }catch (SQLException ex){
            System.err.println("Соединение не установлено");
            ex.printStackTrace(); // Понадобился, чтобы отловить исключения, скрытые выводом на экран предупреждения
            return;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Соединение с БД закрыто");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
