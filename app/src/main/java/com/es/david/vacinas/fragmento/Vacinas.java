package com.es.david.vacinas.fragmento;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.es.david.vacinas.R;
import com.es.david.vacinas.RecyclerItemClickListener;
import com.es.david.vacinas.activity.DetalhesActivity;
import com.es.david.vacinas.adapter.Adapter;
import com.es.david.vacinas.modelo.Vacina;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Vacinas extends Fragment {

    private RecyclerView recyclerView;
    List<Vacina> listaVacinas;
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();



    public static Vacinas newInstance() {
        Vacinas campanhas = new Vacinas();
        return new Vacinas();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_campanhas, null);

        final DatabaseReference vacinas = referencia.child("vacinas");
        listaVacinas = new ArrayList<Vacina>();

        vacinas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot vacinaSnapshot : dataSnapshot.getChildren()) {
                    Vacina vacina = vacinaSnapshot.getValue(Vacina.class);
                    listaVacinas.add(vacina);
                }

                recyclerView = rootView.findViewById(R.id.campanhasView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(new Adapter(listaVacinas));

                //Click Event
                recyclerView.addOnItemTouchListener(

                        new RecyclerItemClickListener(
                                getContext(),
                                recyclerView,
                                new RecyclerItemClickListener.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position) {

                                        Intent intent = new Intent(getContext(), DetalhesActivity.class);
                                        intent.putExtra("vacina", listaVacinas.get(position));

                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onLongItemClick(View view, int position) {
                                        Toast.makeText(getContext(), "Mas aí segura memo", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    }
                                }
                        )
                );
//
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        return rootView;



    }


    @Override
    public String toString() {
         return "Vacinas";
    }
}
