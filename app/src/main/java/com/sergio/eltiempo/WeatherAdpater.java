package com.sergio.eltiempo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> mWeatherList;//los items que iremos mostrando
    private LayoutInflater mInflater;//para inflar cada uno delos layout de cada item

        //CONSTRUCTOR
        public WeatherAdapter(Context context, List<Weather> weatherList) {//context no se deberia
            mInflater = LayoutInflater.from(context);// si hay 20 creara 20
            this.mWeatherList = weatherList;
            //this.context=context;// no necesaria , podemos eliminar arriva private Context context
        }
    class WeatherViewHolder extends RecyclerView.ViewHolder  { // NUNCA CAMBIA ESTA FRASE

        public final TextView txtTitle;
        public final TextView txtContent;

        public WeatherViewHolder(View itemView) {

            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtContent=itemView.findViewById(R.id.txtContent);
            //this.mAdapter=adapter;
        }
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


    public class WeatherViewHolder {
    }
}
