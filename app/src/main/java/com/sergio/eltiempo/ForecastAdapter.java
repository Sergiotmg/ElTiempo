package com.sergio.eltiempo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<Forecast> forecastList;
    //private List<Forecast> forecastList= new ArrayList<>(); nunca sera vacia y
    // luego en el getItemCount()  no hace falta esto: if (forecastList==null) return  0;
    private LayoutInflater mInflater;
    private Context context;


        //CONSTRUCTOR
        // podemos no pasrle la List por ahi
        public ForecastAdapter(Context context, List<Forecast> weatherList) {//context no se deberia
            mInflater = LayoutInflater.from(context);// los inflará
            this.forecastList = weatherList;
            //this.forecastList = forecastList;
            this.context=context;// no necesaria , podemos eliminar arriba private Context context

        }
        // si declaro la clase abstracta, no hara falta implementar todos los methods
    class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // NUNCA CAMBIA ESTA FRASE
        public final ConstraintLayout mConstraintLayout;

        // etiquetas del forecast_item, al ser final son ctes
        public final ImageView ImgState;
        public final TextView TxtDate;
        public final TextView TxtWindDirection;
        public final TextView TxtMaxTemp;
        public final TextView TxtMinTemp;
        public final TextView TxtWindSpeed;
        public final TextView TxtActTemp;

        // etiquetas del activity_main
        public final TextView  mTxtTitle;
        // declaro adaptadores
        final ForecastAdapter mWeAdapter;
        //final ForecastAdapter mAdapter;

        // constructor para el ForecastViewHolder
        public ForecastViewHolder(View itemView,ForecastAdapter adapter) {
            super(itemView);
            ImgState=itemView.findViewById(R.id.imgState);
            TxtDate=itemView.findViewById(R.id.txtDate);
            TxtWindDirection=itemView.findViewById(R.id.txtWindDirection);
            TxtMinTemp =itemView.findViewById(R.id.txtMinTemp);
            TxtMaxTemp =itemView.findViewById(R.id.txtMaxTemp);
            TxtWindSpeed=itemView.findViewById(R.id.txtWindSpeed);
            TxtActTemp=itemView.findViewById(R.id.txtActTemp);

            mTxtTitle=itemView.findViewById(R.id.txtTitle);

            this.mWeAdapter = adapter;

            itemView.setOnClickListener(this);
            //this.mAdapter=adapter;

            mConstraintLayout = itemView.findViewById(R.id.constraintLayout_items);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            //Forecast element = forecastList.get(mPosition);
        }
    }

    @NonNull
    @Override
    public ForecastAdapter.ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView=mInflater.inflate(R.layout.forecast_item,parent,false);
        //(................ , .............. , .........)
        //el layout, donde lo vamos a cargar y si queremos attacherarlo a el( false porque nunca se fija al padre
        // generamos una variable y la devovlemos , en este caso directamente
        return new ForecastViewHolder(mItemView,this);
        //return new ForecastViewHolder(mItemView); Nacho lo pone sin this
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapter.ForecastViewHolder holder, int position) {
        Forecast mCurrent = forecastList.get(position);

        // coger la imagen de la clase Forecast NO SE COMO SE HACE
        //holder.mImgState.setImageResource(mCurrent.getConsolidated_weather());
        String url="https://www.metaweather.com/static/img/weather/png/64/"+mCurrent.getWeather_state_abbr()+".png";
        Glide.with(context).load(url).into(holder.ImgState);

        holder.TxtActTemp.setText(get1DecimalNumber(mCurrent.getThe_temp())+" ºC");

        holder.TxtMaxTemp.setText(get1DecimalNumber(mCurrent.getMax_temp())+" ºC");
        holder.TxtMinTemp.setTextColor(Color.RED);

        holder.TxtMinTemp.setText(get1DecimalNumber(mCurrent.getMin_temp())+" ºC");
        holder.TxtMinTemp.setTextColor(Color.BLUE);

        holder.TxtWindDirection.setText(mCurrent.getWind_direction_compass());
        holder.TxtWindSpeed.setText(get1DecimalNumber(mCurrent.getWind_speed())+" Km/h");
        holder.TxtDate.setText(mCurrent.getApplicable_date());
        //holder.mTxtTitle.setText(mCurrent.get);
        Log.d("weather ADAPTER:",url);
        holder.mConstraintLayout.setBackgroundColor(9);
    }

    @Override
    public int getItemCount() {
        if (forecastList==null) return  0;
        return forecastList.size();
    }

     public String get1DecimalNumber(float number){
         DecimalFormat df=new DecimalFormat("#.#");
         df.setRoundingMode(RoundingMode.CEILING.HALF_EVEN);
         return df.format(number);
     }
    public void setData(List<Forecast> newList){
            forecastList=newList;
            notifyDataSetChanged();//actualiza toda la lista entera
    }



}
