package com.es.david.vacinas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.es.david.vacinas.R;
import com.es.david.vacinas.adapter.Adapter;
import com.es.david.vacinas.modelo.Vacina;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CampanhasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Vacina> listaVacinas = new ArrayList<>();
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanhas);

        recyclerView = findViewById(R.id.campanhasView);

        DatabaseReference vacinas = referencia.child("vacinas");

        vacinas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot vacinaSnapshot : dataSnapshot.getChildren()) {
                    Vacina vacina = vacinaSnapshot.getValue(Vacina.class);
                    listaVacinas.add(vacina);
                }
                Adapter adapter = new Adapter(listaVacinas);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
//                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ///////
    }
}
