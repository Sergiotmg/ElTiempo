package com.sergio.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    private RecyclerView mRecyclerView;
    private  ForecastAdapter mForecastAdapter;
    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller= new Controller(this);
        controller.start();
        mForecastAdapter=new ForecastAdapter(this);

        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setAdapter(mForecastAdapter);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        txtTitle =findViewById(R.id.txtTitle);


    }
    // necesitamos qwue nos pase la respuesta . Es oblig implementaro
    @Override
    public void onResponse(Weather weather) {//llegara un weather cada vez

        mForecastAdapter.setData(weather.getConsolidated_weather());
        //weather.getConsolidated_weather();
        // la lista del getconsolidated_weather es lo que hay que pasrle al recicylerView
        txtTitle.setText(weather.getTitle());
        Toast.makeText(this,weather.getTitle(),Toast.LENGTH_LONG).show();



    }

}
