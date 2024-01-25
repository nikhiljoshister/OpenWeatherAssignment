package com.app.openweatherapi.service.impl;

import com.app.openweatherapi.controller.WeatherController;
import com.app.openweatherapi.exception.WeatherFormatExtension;
import com.app.openweatherapi.modelDto.DailyDto;
import com.app.openweatherapi.modelDto.WeatherResponseDto;
import com.app.openweatherapi.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class WeatherServiceImpl implements WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private WebClient webClient;
    private final String URI = "https://api.openweathermap.org/data/2.5/onecall";
    private final String APP_ID = "44d972716a576f33e58ba3112e9a3cdd";
    private WeatherResponseDto weatherResponseDto = null;

    @Override
    public WeatherResponseDto getCompleteWeatherData(String lat, String lon) {


        logger.info("Using WebClient to parse the Response ...");

        weatherResponseDto = webClient.get()
                .uri(this.url(lat, lon))
                .retrieve()
                .bodyToMono(WeatherResponseDto.class)
                .block();

        return weatherResponseDto;
    }

    @Override
    public DailyDto getDailyWeather(String lat, String lon) {

        logger.info("Getting Daily Weather ...");

        DailyDto[] dailyWeatherDtos = null;
        AtomicInteger s = new AtomicInteger(0);

        weatherResponseDto = getCompleteWeatherData(lat, lon);
        dailyWeatherDtos = weatherResponseDto.getDaily();
        Arrays.stream(dailyWeatherDtos)
                .limit(5)
                .map(el -> el.setDay(s.getAndIncrement()))
                .forEach((el) -> System.out.print(""));

        return getMinOfFeelsLikeMaxOfWindSpeed(dailyWeatherDtos);

    }

    private String url(String lat, String lon) {

        return String.format(URI.concat("?lat=%s").concat("&lon=%s").concat("&appid=%s"), lat, lon, APP_ID);
    }

    private DailyDto getMinOfFeelsLikeMaxOfWindSpeed(DailyDto[] dailyDtos) {


        logger.info("Calculating the min temperatures during the day in next 5 days ...");

        return Arrays.stream(dailyDtos)
                .filter(Objects::nonNull)
                .min((item1, item2) -> {

                    double min1 = item1.getTemp().getMin();
                    double min2 = item2.getTemp().getMin();

                    if (min1 != min2)
                        return Double.compare(min1, min2);

                    double feels_like1 = item1.getFeels_like().getDay();
                    double feels_like2 = item2.getFeels_like().getDay();

                    double wind_speed1 = item1.getWind_speed();
                    double wind_speed2 = item2.getWind_speed();

                    if (feels_like1 != feels_like2)
                        return Double.compare(feels_like1, feels_like2);

                    return Double.compare(feels_like1, feels_like2) & (int) Double.max(wind_speed1, wind_speed2);

                }).orElseThrow(() -> new WeatherFormatExtension("Exception Parsing API data"));
    }
}
