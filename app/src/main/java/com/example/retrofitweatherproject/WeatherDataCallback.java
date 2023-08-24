package com.example.retrofitweatherproject;
public interface WeatherDataCallback {
    void onWeatherDataReceived(double temperature);
    void onWeatherDataFailed(String errorMessage);
}
