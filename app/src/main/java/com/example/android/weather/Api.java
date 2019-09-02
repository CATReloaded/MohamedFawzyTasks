package com.example.android.weather;

import com.example.android.weather.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface Api {
  @GET("data/2.5/weather?")
  Call<Example> getByCity(@Query("q") String q,@Query("appid") String appid);
}
