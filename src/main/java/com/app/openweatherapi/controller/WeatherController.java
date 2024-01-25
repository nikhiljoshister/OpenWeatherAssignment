package com.app.openweatherapi.controller;


import com.app.openweatherapi.modelDto.DailyDto;
import com.app.openweatherapi.modelDto.WeatherResponseDto;
import com.app.openweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class WeatherController {
    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/completeweatherdetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherResponseDto> weatherForecast(@RequestParam(required = true) String lat, @RequestParam(required = true) String lon) {
        logger.info("Fetching details from OpenWeatherAPI ...");

        return new ResponseEntity<>(weatherService.getCompleteWeatherData(lat, lon), HttpStatus.OK);
    }

    @GetMapping(value = "/coldestfivedays", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DailyDto> getDailyWeather(@RequestParam(required = true) String lat, @RequestParam(required = true) String lon) {
        logger.info("Fetching daily details from OpenWeatherAPI ...");

        return new ResponseEntity<>(weatherService.getDailyWeather(lat, lon), HttpStatus.OK);
    }
}
