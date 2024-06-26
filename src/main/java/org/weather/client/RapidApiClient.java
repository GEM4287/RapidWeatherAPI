package org.weather.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.logging.Logger;

@Component
@Slf4j
public class RapidApiClient
{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final OkHttpClient httpClient = new OkHttpClient();

    @Value("${rapidApi.apiKey}")
    private String apiKey;

    @Value("${rapidApi.host}")
    private String host;

    @Value("${rapidApi.forecastURL}")
    private String url;

    public String getSummaryByLocation(String location)
    {
        Request request = new Request.Builder()
            .url(url + location + "/summary/")
            .get()
            .addHeader("X-RapidAPI-Key", apiKey)
            .addHeader("X-RapidAPI-Host", host)
            .build();
        return getJsonNode(request);
    }

    public String getHourlyForecastByLocation(String location){
        Request request = new Request.Builder()
            .url(url + location + "/hourly/")
            .get()
            .addHeader("X-RapidAPI-Key", apiKey)
            .addHeader("X-RapidAPI-Host", host)
            .build();
        return getJsonNode(request);
    }

    private String getJsonNode(Request request) {
        try{
            return Objects.requireNonNull(httpClient.newCall(request).execute().body()).string();
        } catch (Exception exception) {
            logger.warning("Error: " + exception.getMessage());
        }
        return null;
    }
}
