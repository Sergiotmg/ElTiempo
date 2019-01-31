package com.sergio.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller= new Controller(this);
        controller.start();

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


    }
    // necesitamos qwue nos pase la respuesta . Es oblig implementaro
    @Override
    public void onResponse(Weather weather) {//llegara un weather cada vez
        weather.getConsolidated_weather();
        // la lista del getconsolidated_weather es lo que hay que pasrle al recicylerView
        Toast.makeText(this,weather.getTitle(),Toast.LENGTH_LONG).show();



    }

}
