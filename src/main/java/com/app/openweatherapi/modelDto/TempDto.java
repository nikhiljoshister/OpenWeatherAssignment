package com.app.openweatherapi.modelDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TempDto {
    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;
}
