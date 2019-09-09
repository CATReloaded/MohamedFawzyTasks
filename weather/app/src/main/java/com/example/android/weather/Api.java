package com.example.android.weather;

import com.example.android.weather.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface Api {
  @GET("weather")
  Call<Example> getByCity(@Query("q") String city,@Query("appid") String appid);
}
