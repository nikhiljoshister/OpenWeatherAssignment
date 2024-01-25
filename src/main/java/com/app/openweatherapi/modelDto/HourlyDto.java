package com.app.openweatherapi.modelDto;

import lombok.Getter;

@Getter
public class HourlyDto {

    private long dt;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private int uvi;
    private int clouds;
    private int visibility;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private CurrentWeatherDto[] weather;
    private int pop;
}
