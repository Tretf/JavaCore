package lesson7_hw;

import java.io.IOException;

public interface WeatherModel {

    default void getWeather(String city, Period period) throws IOException {
    }
}
