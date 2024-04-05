package org.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weather.client.RapidApiClient;

@RestController
@RequestMapping("/api/v1/forecast")
public class RapidApiController
{
    @Autowired
    private RapidApiClient rapidApiClient;

    @GetMapping("/summary/{locationName}")
    public ResponseEntity<String> getSummaryByLocation(@PathVariable String locationName) {
        String data = rapidApiClient.getSummaryByLocation(locationName);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<String> getHourlyForecastByLocation(@PathVariable String locationName){
        String data = rapidApiClient.getHourlyForecastByLocation(locationName);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }
}
