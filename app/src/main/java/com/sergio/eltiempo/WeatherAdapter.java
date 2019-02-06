package com.sergio.eltiempo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<Weather> mWeatherList;
    //private List<Weather> mWeatherList;
    private LayoutInflater mInflater;
    //private Context context;


    //CONSTRUCTOR
    public WeatherAdapter(Context context, List<Weather> weatherList) {//context no se deberia
        mInflater = LayoutInflater.from(context);// si hay 20 creara 20
        this.mWeatherList = weatherList;
        //this.mWeatherList = forecastList;
        //this.context=context;// no necesaria , podemos eliminar arriba private Context context

    }
    class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // NUNCA CAMBIA ESTA FRASE
        public final ConstraintLayout mConstraintLayout;

        // etiquetas del activity_main
        public final TextView  mTxtTitle;
        // declaro adaptadores
        final WeatherAdapter mWeAdapter;
        //final WeatherAdapter mAdapter;

        // constructor para el WeatherViewHolder
        public WeatherViewHolder(View itemView,WeatherAdapter adapter) {

            super(itemView);

            mTxtTitle=itemView.findViewById(R.id.txtTitle);

            this.mWeAdapter = adapter;

            itemView.setOnClickListener(this);
            //this.mAdapter=adapter;

            mConstraintLayout = itemView.findViewById(R.id.constraintLayout_main);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            //Weather element = mWeatherList.get(mPosition);
        }
    }

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView=mInflater.inflate(R.layout.activity_main,parent,false);
        return new WeatherViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        Weather mCurrent =mWeatherList.get(position);


        holder.mTxtTitle.setText(mCurrent.getTitle());

        holder.mConstraintLayout.setBackgroundColor(9);
    }


    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }



}
