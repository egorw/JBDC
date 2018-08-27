package com.devcolibri.database;




import java.sql.*;

public class Main {
   /* public static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
*/
    public static void main(String[] args) {

        DBWorker dbWorker = new DBWorker();

        String qerry = "select * from users_tb where id = 2";
        try {
            Statement statement = dbWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(qerry);

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                System.out.println(user);
               /* int id = resultSet.getInt(1);
                System.out.println(id);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





       /* Connection connection = null;
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
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch1', 'desc');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch2', 'desc');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('batch3', 'desc');");

            statement.executeBatch();

            statement.clearBatch();
            statement.getConnection();

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
        }*/
    }
}
