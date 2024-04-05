package org.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weather.client.RapidApiClient;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/forecast")
public class RapidApiController
{
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private RapidApiClient rapidApiClient;

    @GetMapping("/summary/{locationName}")
    public ResponseEntity<String> getSummaryByLocation(@PathVariable String locationName) {
        logger.info("Calling Summary API to get the details for location : " + locationName);
        String data = rapidApiClient.getSummaryByLocation(locationName);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<String> getHourlyForecastByLocation(@PathVariable String locationName){
        logger.info("Calling Hourly API to get the details for location : " + locationName);
        String data = rapidApiClient.getHourlyForecastByLocation(locationName);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }
}
