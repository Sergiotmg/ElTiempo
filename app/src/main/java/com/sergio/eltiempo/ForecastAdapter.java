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
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<Forecast> mForecastList;
    //private List<Forecast> mForecastList;
    private LayoutInflater mInflater;
    //private Context context;


        //CONSTRUCTOR
        public ForecastAdapter(Context context, List<Forecast> weatherList) {//context no se deberia
            mInflater = LayoutInflater.from(context);// si hay 20 creara 20
            this.mForecastList = weatherList;
            //this.mForecastList = forecastList;
            //this.context=context;// no necesaria , podemos eliminar arriba private Context context

        }
    class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { // NUNCA CAMBIA ESTA FRASE
        public final ConstraintLayout mConstraintLayout;

        // etiquetas del forecast_item
        public final ImageView mImgState;
        public final TextView  mTxtDate;
        public final TextView mTxtWindDirection;
        public final TextView mTxtMaxTemp;
        public final TextView mTxtMinTemp;
        public final TextView mTxtWindSpeed;
        public final TextView mTxtActTemp;

        // etiquetas del activity_main
        public final TextView  mTxtTitle;
        // declaro adaptadores
        final ForecastAdapter mWeAdapter;
        //final ForecastAdapter mAdapter;

        // constructor para el ForecastViewHolder
        public ForecastViewHolder(View itemView,ForecastAdapter adapter) {

            super(itemView);


            mImgState=itemView.findViewById(R.id.imgState);
            mTxtDate=itemView.findViewById(R.id.txtDate);
            mTxtWindDirection=itemView.findViewById(R.id.txtWindDirection);
            mTxtMinTemp =itemView.findViewById(R.id.txtMinTemp);
            mTxtMaxTemp =itemView.findViewById(R.id.txtMaxTemp);
            mTxtWindSpeed=itemView.findViewById(R.id.txtWindSpeed);
            mTxtActTemp=itemView.findViewById(R.id.txtActTemp);

            mTxtTitle=itemView.findViewById(R.id.txtTitle);

            this.mWeAdapter = adapter;

            itemView.setOnClickListener(this);
            //this.mAdapter=adapter;

            mConstraintLayout = itemView.findViewById(R.id.constraintLayout_items);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            //Forecast element = mForecastList.get(mPosition);
        }
    }

    @NonNull
    @Override
    public ForecastAdapter.ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView=mInflater.inflate(R.layout.forecast_item,parent,false);
        return new ForecastViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapter.ForecastViewHolder holder, int position) {
        Forecast mCurrent = mForecastList.get(position);

        // coger la imagen de la clase Forecast NO SE COMO SE HACE
        //holder.mImgState.setImageResource(mCurrent.getConsolidated_weather());

        holder.mTxtActTemp.setText(mCurrent.getThe_temp().intValue());
        holder.mTxtMaxTemp.setText(mCurrent.getMax_temp().intValue());
        holder.mTxtMinTemp.setText(mCurrent.getMin_temp().intValue());
        holder.mTxtWindDirection.setText(mCurrent.getWind_direction_compass());
        holder.mTxtWindSpeed.setText(mCurrent.getWind_speed().intValue());
        holder.mTxtDate.setText(mCurrent.getApplicable_date());

        holder.mConstraintLayout.setBackgroundColor(9);
    }


    @Override
    public int getItemCount() {
        return mForecastList.size();
    }



}
