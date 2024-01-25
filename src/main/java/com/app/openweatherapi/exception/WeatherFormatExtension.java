package com.app.openweatherapi.exception;

public class WeatherFormatExtension extends RuntimeException{
    public WeatherFormatExtension(String message) {
        super(message);
    }
}
