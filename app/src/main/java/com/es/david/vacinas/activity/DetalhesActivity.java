package com.es.david.vacinas.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.es.david.vacinas.R;
import com.es.david.vacinas.modelo.Vacina;

public class DetalhesActivity extends AppCompatActivity {
    Vacina vacina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dados = getIntent().getExtras();
        assert dados != null;
        Vacina vacina = (Vacina) dados.getSerializable("vacina");
        this.vacina = vacina;

       // Toolbar toolbar = findViewById(R.id.toolbar);


        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(vacina.getNome());

        ((TextView)findViewById(R.id.textoVacina)).setText(vacina.getDetalhes());



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        //TODO Conferir o que este botão faz a corrigir. Ele estava travando o programa.

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
