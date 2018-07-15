package com.es.david.vacinas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.es.david.vacinas.R;
import com.es.david.vacinas.fragmento.Campanhas;
import com.es.david.vacinas.modelo.Vacina;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetalhesMeusActivity extends AppCompatActivity {
    Vacina vacina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dados = getIntent().getExtras();
        assert dados != null;
        Vacina vacina = (Vacina) dados.getSerializable("vacina");
        this.vacina = vacina;

        String tipo = dados.get("tipo").toString();

        //Previously Funcionando



        //After funciona





        setContentView(R.layout.activity_detalhes_meus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(vacina.getNome());
        ((TextView)findViewById(R.id.textoMyVacina)).setText(vacina.getDetalhes());

       // setVacina(vacina);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
//        });

        if (tipo.equals("vacina")) {
            fab.hide();

        }
    }

    private Vacina getVacina() {
        return this.vacina;
    }

    public void setVacina(View view) {
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference vacinasSetada = referencia.child("usuarios").child("usuario").child("minhaVacinas");

        vacinasSetada.push().setValue(getVacina());

        Toast.makeText(getApplicationContext(), (getVacina().getNome() + " adicionada a MINHAS VACINAS") , Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("frgToLoad", "vacinas");
        startActivity(i);
    }
}
