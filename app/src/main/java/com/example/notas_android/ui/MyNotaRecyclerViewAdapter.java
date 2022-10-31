package com.example.notas_android.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.notas_android.db.entity.NotaEntity;
import com.example.notas_android.R;
import com.example.notas_android.databinding.FragmentItemBinding;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {


    private final List<NotaEntity> mValues;
    private Context ctx;

    public MyNotaRecyclerViewAdapter(List<NotaEntity> items, Context ctx) {
        mValues = items;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvContenido.setText(holder.mItem.getContenido());

        if(holder.mItem.isFavorita()){
            holder.ivFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }

        holder.ivFavorita.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvTitulo;
        public final TextView tvContenido;
        public final ImageView ivFavorita;
        public NotaEntity mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            tvTitulo = binding.textViewTitulo;
            tvContenido = binding.textViewContenido;
            ivFavorita = binding.imageViewFavorita;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvTitulo.getText() + "'";
        }
    }
}