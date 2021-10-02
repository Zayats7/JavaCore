package Lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class AccuweatherModel implements WeatherModel
{
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = "DhPv84UUhrthwz0lN7UBs0EsBQmDKFoK";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/
    private static final String PROTOKOL5 = "https";
    private static final String BASE_HOST5 = "dataservice.accuweather.com";
    private static final String FORECASTS5 = "forecasts";
    private static final String VERSION5 = "v1";
    private static final String DAILY5 = "daily";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY5 = "DhPv84UUhrthwz0lN7UBs0EsBQmDKFoK";
    private static final String API_KEY_QUERY_PARAM5 = "apikey";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException
    {
        switch (period)
        {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();

                String weather = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Date").asText();
                System.out.println("Date: "+weather);

                String weather1 = objectMapper.readTree(weatherResponse).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather1);

                String weather2 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather2);

                String weather3 = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather3);

                break;

            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOKOL5)
                        .host(BASE_HOST5)
                        .addPathSegment(FORECASTS5)
                        .addPathSegment(VERSION5)
                        .addPathSegment(DAILY5)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM5, API_KEY5)
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .get()
                        .addHeader("accept", "application/json")
                        .build();

                Response oneDayForecastResponse5 = okHttpClient.newCall(request5).execute();
                String weatherResponse5 = oneDayForecastResponse5.body().string();

                String weather5 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(0).at("/Date").asText();
                System.out.println("Date: "+weather5);

                String weather6 = objectMapper.readTree(weatherResponse5).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather6);

                String weather7 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(0).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather7);

                String weather8 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(0).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather8);

                System.out.println("----------------------------------");

                String weather55 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(1).at("/Date").asText();
                System.out.println("Date: "+weather55);

                String weather66 = objectMapper.readTree(weatherResponse5).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather66);

                String weather77 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(1).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather77);

                String weather88 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(1).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather88);

                System.out.println("----------------------------------");

                String weather555 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(2).at("/Date").asText();
                System.out.println("Date: "+weather555);

                String weather666 = objectMapper.readTree(weatherResponse5).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather666);

                String weather777 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(2).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather777);

                String weather888 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(2).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather888);

                System.out.println("----------------------------------");

                String weather5555 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(3).at("/Date").asText();
                System.out.println("Date: "+weather5555);

                String weather6666 = objectMapper.readTree(weatherResponse5).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather6666);

                String weather7777 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(3).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather7777);

                String weather8888 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(3).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather8888);

                System.out.println("----------------------------------");

                String weather55555 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(4).at("/Date").asText();
                System.out.println("Date: "+weather55555);

                String weather66666 = objectMapper.readTree(weatherResponse5).at("/Headline").at("/Text").asText();
                System.out.println("Message: "+weather66666);

                String weather77777 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(4).at("/Temperature")
                        .at("/Minimum").at("/Value").asText();
                System.out.println("Mimimum temperature: "+weather77777);

                String weather88888 = objectMapper.readTree(weatherResponse5).at("/DailyForecasts").get(4).at("/Temperature")
                        .at("/Maximum").at("/Value").asText();
                System.out.println("Maximum temperature: "+weather88888);
                break;
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather()
    {
        return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException
    {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        String location = objectMapper.readTree(responseString).get(0).at("/LocalizedName").asText();
        System.out.println("City: "+location);
        return cityKey;
    }
}
