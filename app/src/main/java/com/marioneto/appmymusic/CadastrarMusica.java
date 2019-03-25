package com.marioneto.appmymusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.util.RepositorioMusicas;

public class CadastrarMusica extends AppCompatActivity {
    private Spinner spnGenero;
    private SeekBar skAno, skDuracao;
    private TextView tvAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_musica);

        spnGenero = findViewById(R.id.spn_genero);
        skAno = findViewById(R.id.sk_ano);
        tvAno = findViewById(R.id.tv_ano);


        ArrayAdapter<Genero> adapter;
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                RepositorioMusicas.getCatalogo().getListaGeneros());
        spnGenero.setAdapter(adapter);


        skAno.setMax(119);
        skAno.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAno.setText(""+(1900+progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
