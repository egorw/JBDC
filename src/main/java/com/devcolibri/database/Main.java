package com.devcolibri.database;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id = ?";


    public static void main(String[] args) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                float rating = result.getFloat("rating");
                boolean published = result.getBoolean("published");
                Date date = result.getDate("created");
                byte[] icon = result.getBytes("icon");

                System.out.println("id: " + id + ", title: " + title + ", description: " + description +
                ", rating: " + rating + ", published: " + published + ", created: " + date + ", icon length: " +
                icon.length);
            }
            /*preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Inerted title");
            preparedStatement.setString(3, "Inserted desc");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));

            preparedStatement.setBlob(7, new FileInputStream("Smile.png"));

            preparedStatement.execute();*/

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
