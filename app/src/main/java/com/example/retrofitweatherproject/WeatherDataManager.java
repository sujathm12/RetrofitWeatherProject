package com.example.retrofitweatherproject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherDataManager {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "4f4cf3efa1a88347954bc631531a0eec";
    private WeatherApiService apiService;

    public WeatherDataManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(WeatherApiService.class);
    }

    public void getWeatherData(double latitude, double longitude, final WeatherDataCallback callback) {
        Call<WeatherResponse> call = apiService.getWeatherData(latitude, longitude, API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse weatherResponse = response.body();
                    if (weatherResponse != null) {
                        double temperature = weatherResponse.getMainWeatherData().getTemperature();
                        callback.onWeatherDataReceived(temperature);
                    }
                } else {
                    callback.onWeatherDataFailed("Weather data retrieval failed.");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                callback.onWeatherDataFailed("Weather API call failed: " + t.getMessage());
            }
        });
    }
}
