package com.example.rm40217.carrroapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rm40217.carrroapp.R;
import com.example.rm40217.carrroapp.model.Carro;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by rm40217 on 19/11/2015.
 */
public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarroViewHolder> {

    private Context context;
    private List<Carro> carros;

    public CarroAdapter(Context context, List<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carro_row, parent, false);
        return new CarroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        try {
            holder.tvNomeCarro.setText(carros.get(position).getNome());
            holder.tvDescCarro.setText(carros.get(position).getDesc());

            InputStream is = context.getAssets().open(carros.get(position).getFoto());
            Drawable fotoCarro = Drawable.createFromStream(is, null);
            holder.ivCarro.setImageDrawable(fotoCarro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder {
        TextView tvNomeCarro;
        TextView tvDescCarro;
        ImageView ivCarro;
        ImageView ivOpcoes;
        ProgressBar pbCarro;

        public CarroViewHolder(View itemView) {
            super(itemView);
            tvNomeCarro = (TextView) itemView.findViewById(R.id.tvNomeCarro);
            tvDescCarro = (TextView) itemView.findViewById(R.id.tvDescCarro);
            ivCarro = (ImageView) itemView.findViewById(R.id.ivCarro);
            ivOpcoes = (ImageView) itemView.findViewById(R.id.ivOpcoes);
            pbCarro = (ProgressBar) itemView.findViewById(R.id.pbCarro);
        }
    }
}
