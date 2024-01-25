package com.app.openweatherapi.modelDto;

import lombok.Getter;

@Getter
public class CurrentWeatherDto {

    private long id;
    private String main;
    private String description;
    private String icon;

}
