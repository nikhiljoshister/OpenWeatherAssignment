package com.app.openweatherapi.modelDto;

import lombok.Getter;

@Getter
public class CurrentDto {

    private long dt;
    private long sunrise;
    private long sunset;
    private double temp;
    private double feels_like;
    private long pressure;
    private long humidity;
    private double dew_point;
    private int uvi;
    private int clouds;
    private long visibility;
    private double wind_speed;
    private double wind_deg;
    private double wind_gust;
    private CurrentWeatherDto[] weather;


}
