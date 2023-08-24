package com.example.retrofitweatherproject;
import com.google.gson.annotations.SerializedName;


public class MainWeatherData {
    @SerializedName("temp")
     double temperature;

    @SuppressWarnings("unused")
    public double getTemperature() {
        return temperature;
    }
}