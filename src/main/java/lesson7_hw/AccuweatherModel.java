package lesson7_hw;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel{
    //https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/1day/%7BlocationKey%7D
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/{locationKey}
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/


    public static final String PROTOCOL = "http";
    public static final String BASE_HOST = "dataservice.accuweather.com";
    public static final String FORECASTS = "forecasts";
    public static final String VERSION = "v1";
    public static final String DAILY = "daily";
    public static final String ONEDAY = "1day";
    //+
    public static final String FIVEDAYS = "5day";
    //-
    public static final String API_KEY = "pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv";
    public static final String API_KEY_QUERY_PARAM = "apikey";
    public static final String LOCATIONS = "locations";
    public static final String CITIES = "cities";
    public static final String AUTOCOMPLETE = "autocomplete";

    public static final OkHttpClient okHttpClient = new OkHttpClient();
    public static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getWeather(String city, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONEDAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);

                break;
            case FIVE_DAYS:
                HttpUrl httpUrl_5 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVEDAYS)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request_5 = new Request.Builder()
                        .url(httpUrl_5)
                        .build();

                //Response
                oneDayForecastResponse = okHttpClient.newCall(request_5).execute();
                String weatherResponse_5 = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse_5);

                break;
        }

    }

/*    public static void main(String[] args) throws IOException {

        AccuweatherModel accuweatherModel = new AccuweatherModel();
        accuweatherModel.getWeather("Moscow", Period.NOW);

    }*/

    private String detectCityKey(String city) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomlete

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter("q", city)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();
        System.out.println(responseString);

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

        return cityKey;
    }


}
