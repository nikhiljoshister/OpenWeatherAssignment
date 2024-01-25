package com.app.openweatherapi.modelDto;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public class DailyDto {

    private int dayOfFive;
    private long dt;
    private Date date;
    private double weatherInCelsius;
    private double weatherInFahrenheit;
    private TempDto temp;
    private FeelsLikeDto feels_like;
    private double wind_speed;

    public int setDay(int day) {
        this.dayOfFive = day;
        return day;
    }

    public Date getDate() {
        return new Date((long) dt * 1000);
    }

    public double getWeatherInFahrenheit() {
        return ((temp.getDay() - 273.15) * 9 / 5 + 32);
    }

    public double getWeatherInCelsius() {
        return (temp.getDay() - 273.15);
    }

}
