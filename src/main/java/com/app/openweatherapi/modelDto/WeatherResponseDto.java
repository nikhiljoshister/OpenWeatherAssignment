package com.app.openweatherapi.modelDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeatherResponseDto {

    private long lat;
    private long lon;
    private String timezone;
    private long timezone_offset;
    private CurrentDto current;
    private MinutelyDto[] minutely;
    private HourlyDto[] hourly;
    private DailyDto[] daily;


}
