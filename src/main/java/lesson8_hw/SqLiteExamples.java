package lesson8_hw;

import lesson7_hw.DataBaseRepository;

import java.sql.*;

public class SqLiteExamples {

    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:c://sqlite/DB/mytest.db");


            Statement statement = connection.createStatement();
     //       statement.executeUpdate("update faculties set name = 'Test1' where id = 1");

            ResultSet resultSet = statement.executeQuery("select * from students");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("name"));
            }

            long time = System.currentTimeMillis();

/*
            for (int i = 0; i < 10000; i++) {
                statement.executeUpdate(
                        //String.format("insert into students(name, score, faculty_id) values ('Андрей', 10, 1)"));
                        String.format("insert into students(name, score, faculty_id) values ('%s', %d, %d)", "student" + i, i, i));
            }
            System.out.println("Время выполнения с автокоммитом " + (System.currentTimeMillis() - time));

*/

/*

            time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 10000; i < 20000; i++) {
                statement.executeUpdate(
                        String.format("insert into students(name, score, faculty_id) values ('%s', %d, %d)", "student" + i, i, i));
            }
            connection.commit();
            System.out.println("Время выполнения без автокоммита " + (System.currentTimeMillis() - time));

*/


            PreparedStatement preparedStatement = connection.prepareStatement("insert into students(name, score, faculty_id) values (?, ?, ?)");
            connection.setAutoCommit(false);

            preparedStatement.setString(1, "Иван");
            preparedStatement.setInt(2, 19);
            preparedStatement.setInt(3, 1);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Anthon");
            preparedStatement.setInt(2, 10);
            preparedStatement.setInt(3, 12);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Michael");
            preparedStatement.setInt(2, 8);
            preparedStatement.setInt(3, 2);
            preparedStatement.addBatch();

            preparedStatement.executeBatch();


            connection.commit();

            DataBaseRepository.getSavedToDBWeather();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
