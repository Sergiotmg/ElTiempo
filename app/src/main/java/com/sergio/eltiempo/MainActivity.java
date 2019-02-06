package com.sergio.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {
    private Weather mWeather;
    //private List<Forecast> consolidatedWeather;
    private RecyclerView RecyclerView;
    private  ForecastAdapter adapter;
    //private  WeatherAdapter WeatherAdapter;
    private TextView txtTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTitle=findViewById(R.id.txtTitle);

        Controller controller= new Controller(this);
        controller.start();
        //consolidatedWeather=mWeather.getConsolidated_weather(); ESO va abajo en On Response
        RecyclerView=findViewById(R.id.recyclerView);
        //Adapter=new Adapter(this,consolidatedWeather);
        adapter=new ForecastAdapter(this,null);
        RecyclerView.setAdapter(adapter);
        
        LinearLayoutManager manager=new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(manager);




    }
    // necesitamos qwue nos pase la respuesta . Es oblig implementaro
    @Override
    public void onResponse(Weather weather) {//llegara un weather cada vez
        //weather.getConsolidated_weather();
        // la lista del getconsolidated_weather es lo que hay que pasrle al recicylerView
        //Toast.makeText(this,weather.getTitle(),Toast.LENGTH_LONG).show();
        adapter.setData(weather.getConsolidated_weather());
        txtTitle.setText(weather.getTitle());

    }

}
