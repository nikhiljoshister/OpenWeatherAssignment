package com.app.openweatherapi.service;

import com.app.openweatherapi.modelDto.DailyDto;
import com.app.openweatherapi.modelDto.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getCompleteWeatherData(String lat, String lon);
    DailyDto getDailyWeather(String lat, String lon);
}
