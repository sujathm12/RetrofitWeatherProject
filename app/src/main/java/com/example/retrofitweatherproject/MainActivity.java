package com.example.retrofitweatherproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView textViewTemperature;
    private WeatherDataManager weatherDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTemperature = findViewById(R.id.textViewTemperature);
        weatherDataManager = new WeatherDataManager();

        // Replace these latitude and longitude values with the actual coordinates
        double latitude = 37.7749;
        double longitude = -122.4194;

        // Fetch weather data and update the temperature text view
        fetchWeatherData(latitude, longitude);
    }

    private void fetchWeatherData(double latitude, double longitude) {
        weatherDataManager.getWeatherData(latitude, longitude, new WeatherDataCallback() {
            @Override
            public void onWeatherDataReceived(double temperature) {
                // Update the temperature text view with the fetched data
                String temperatureText = String.format("%.1f°C", temperature);
                textViewTemperature.setText(temperatureText);
            }

            @Override
            public void onWeatherDataFailed(String errorMessage) {
                // Handle API call failure, if needed
            }
        });
    }
}