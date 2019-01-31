package com.sergio.eltiempo;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Controller implements Callback<Weather> {
    ServerResponse handler;
    // es el controlador para el retrofit
    // que las clases sean indep,
    //no queremos acceder desde controller a todos los metodos de main , solo ls de interface
    public Controller(ServerResponse handler) {//maneja las respuestas para este cont
        this.handler=handler;
    }

    // contrato entre controller y mainACtivity asegura de que el main acti siempre tiene que incluir
    // los metodos de esa interfaz

    // con CTRL +O implementamos las dos por defecto
    static final String BASE_URL = "https://www.metaweather.com/api/";// mayus por ser CTE

    public void start() {
        // genera un nuevo obj gson
        Gson gson = new GsonBuilder()
                .setLenient()//solo acepta json que sigan la regla RFC 4627
                .create();
        // instancia de retrofit y siempre seran igual!!
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))//con que vamos a convertir
                //podemos utilizar MossyConverterFactory, etc,
                .build();

        WeatherApi gerritAPI = retrofit.create(WeatherApi.class);// nuestro retrofit ya genera dicha
        //class
        //Call<List<Weather>> call = gerritAPI.loadWeather("status:open");// status si le pasaramos
        //algo en loadweather
        Call<Weather> call = gerritAPI.loadWeather();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Weather> call, Response<Weather> response) {
            if(response.isSuccessful()) {
                Weather weather = response.body();
                handler.onResponse(weather);//ya tenemos el weather en el mainactiivity
                Log.d("controller",weather.getTitle());
                //changesList.forEach(change -> System.out.println(change.subject));
            } else {
                Log.d("controller",response.errorBody().toString());
            }
    }
    @Override
    public void onFailure(Call<Weather> call, Throwable t) {
            t.printStackTrace();

    }
    // genero una interface con 1 2 metodos para que el main actitvity impemente esa itnerface y sea
    //oblig que lleve el metodo que podnremos abaj
    public interface ServerResponse{
        // si la interfaz es publica los metodos tambien!
        void onResponse(Weather weather);

    }
}
