package com.es.david.vacinas.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.es.david.vacinas.R;
import com.es.david.vacinas.modelo.Vacina;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Vacina> listaVacinas;

    public Adapter(List<Vacina> lista) {
        this.listaVacinas = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Vacina vacina = listaVacinas.get(position);
        holder.nomeVacina.setText(vacina.getNome());
        holder.data.setText(vacina.getData());
        holder.detalhes.setText(vacina.getDetalhes());
    }

    @Override
    public int getItemCount() {

        return listaVacinas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomeVacina;
        TextView data;
        TextView detalhes;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeVacina = itemView.findViewById(R.id.nomeVacina);
            data = itemView.findViewById(R.id.dataVacina);
            detalhes = itemView.findViewById(R.id.detalhesVacina);
        }
    }
}
