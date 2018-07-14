package com.es.david.vacinas.fragmento;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.es.david.vacinas.R;
import com.es.david.vacinas.adapter.Adapter;
import com.es.david.vacinas.modelo.Vacina;

import java.util.ArrayList;
import java.util.List;

public class Campanhas extends Fragment {

    private RecyclerView recyclerView;
    List<Vacina> vacinas;
//    private String[] cidades = {"Paragominas" , "Imperatriz", "Codó"};

    public static Campanhas newInstance() {
        Campanhas campanhas = new Campanhas();
        return new Campanhas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_campanhas, null);

        vacinas = new ArrayList<>();
        vacinas.add(new Vacina("Vacina Campanha", "Data campanha", "detalhes campanha"));

        recyclerView = rootView.findViewById(R.id.campanhasView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new Adapter(vacinas));


//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
////                recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public String toString() {
         return "Campanhas";
    }
}
