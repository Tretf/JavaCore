package lesson6_hw;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class UrlConectionExamples {

    public static <requestBody> void main(String[] args) throws IOException {


        // подключение к gb.ru
    /*  URL url = new URL("https", "gb.ru", "/");

        InputStream in = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

          String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();*/


        // подключение к Яндекс погода
        //URL url1 = new URL("https://restful-booker.herokuapp.com/auth");
        URL url1 = new URL("https://yandex.ru/pogoda/reftinsky?utm_campaign=informer&utm_source=home&utm_content=main_informer&utm_medium=web&utm_term=title&lat=57.091297&lon=61.67442");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();

        /*httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String requestBody = "{\n" + "\"usernsme\":\"admin\", \n" + "\"password\":\"password123\"\n" + "}";*/

        //System.out.println(requestBody);

    /*    try ( BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()))) {
            bufferedWriter.write(requestBody);
        }*/



        try (BufferedReader bufferedReader1 = new  BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String temp;
            while ((temp = bufferedReader1.readLine()) != null) {
                System.out.println(temp);
            }
        }



       // Получение информации о запросе
        System.out.println("Метод запроса:" + httpURLConnection.getRequestMethod());
        System.out.println("Код ответа:" + httpURLConnection.getResponseCode());
        System.out.println("Ответное сообщение:" + httpURLConnection.getResponseMessage());

        // Получение заголовков
        Map<String, List<String>> headers = httpURLConnection.getHeaderFields();
        for (String k:  headers.keySet()) {
            System.out.printf("Ключ: %s, значение: %s \n", k, headers.get(k));
        }



    }
}
