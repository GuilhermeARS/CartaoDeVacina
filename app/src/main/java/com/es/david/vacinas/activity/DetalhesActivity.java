package com.es.david.vacinas.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.es.david.vacinas.R;
import com.es.david.vacinas.modelo.Vacina;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DetalhesActivity extends AppCompatActivity {
    Vacina vacina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dados = getIntent().getExtras();
        assert dados != null;
        Vacina vacina = (Vacina) dados.getSerializable("vacina");
        this.vacina = vacina;

        String tipo = dados.get("tipo").toString();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddVacina);

        if (tipo.equals("vacina")) {
          //  fab;
        }

        // Toolbar toolbar = findViewById(R.id.toolbar);


        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(vacina.getNome());

        ((TextView)findViewById(R.id.textoVacina)).setText(vacina.getDetalhes());

//        setarVacina(vacina);



        //TODO Conferir o que este botão faz a corrigir. Ele estava travando o programa.

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    private void setarVacina(Vacina vacinaRecebida) {
//
//        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
//        final DatabaseReference vacinasSetada = referencia.child("usuarios").child("usuario").child("minhaVacinas");
//
//        vacinasSetada.push().setValue(vacinaRecebida);
//    }

    private Vacina getVacina() {
        return this.vacina;
    }


    public void setarVacina(View view) {
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference vacinasSetada = referencia.child("usuarios").child("usuario").child("minhaVacinas");

        vacinasSetada.push().setValue(getVacina());

        Toast.makeText(getApplicationContext(), (getVacina().getNome() + " adicionada a MINHAS VACINAS") , Toast.LENGTH_SHORT).show();
    }
}
