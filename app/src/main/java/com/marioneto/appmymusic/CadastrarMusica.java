package com.marioneto.appmymusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.util.RepositorioMusicas;

public class CadastrarMusica extends AppCompatActivity {
    private Spinner spnGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_musica);

        spnGenero = findViewById(R.id.spn_genero);
        ArrayAdapter<Genero> adapter;
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                RepositorioMusicas.getCatalogo().getListaGeneros());

        spnGenero.setAdapter(adapter);
    }
}
