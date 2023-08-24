package com.example.retrofitweatherproject;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("main")
    private MainWeatherData mainWeatherData;

    public MainWeatherData getMainWeatherData() {
        return mainWeatherData;
    }
}