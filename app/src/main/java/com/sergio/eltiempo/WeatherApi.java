package com.sergio.eltiempo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    // metodos para hacer las peticiones a las paginas web
    @GET("location/766273/")
    // siempre buscamos en Madrid pero podria cambiarse el 766273
    Call<Weather> loadWeather();
}
