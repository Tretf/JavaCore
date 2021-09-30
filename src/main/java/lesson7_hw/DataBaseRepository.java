package lesson7_hw;

import lesson7_hw.entiti.Weather;

import java.sql.*;
import java.util.List;

public class DataBaseRepository {

    private String insertWeather = "insert into weather(city, localdate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from weather";    // where citi = ?";
    public static String DB_PATH = "jdbc:sqlite:c://sqlite/DB/mytest.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        PreparedStatement saveWeather;
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());

            return saveWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new SQLException("Сохранение в базу не произошло");

    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);

            for (Weather weather: weatherList) {
                saveWeather = connection.prepareStatement(insertWeather);
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new SQLException("Сохранение в базу не произошло");

    }

    public static void getSavedToDBWeather() {


        try (Connection connection = DriverManager.getConnection(DB_PATH)) {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from weather");

            Integer i = 0;
            while (resultSet.next()) {

                System.out.println(resultSet.getInt("id") + " "
                        + resultSet.getString("city")
                        + resultSet.getString("localDate")
                        + String.format("%.2f", resultSet.getDouble("temperature" )));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
