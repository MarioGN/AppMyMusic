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
    private TextView tvAno, tvDuracao;
    private double duracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_musica);

        spnGenero = findViewById(R.id.spn_genero);
        skAno = findViewById(R.id.sk_ano);
        tvAno = findViewById(R.id.tv_ano);
        skDuracao = findViewById(R.id.sk_duracao);
        tvDuracao = findViewById(R.id.tv_duracao);

        ArrayAdapter<Genero> adapter;
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                RepositorioMusicas.getCatalogo().getListaGeneros());
        spnGenero.setAdapter(adapter);


        skAno.setMax(119);
        duracao = 0;
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

        skDuracao.setMax(600);
        skDuracao.setProgress(10);
        skDuracao.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double value = progress/60;
                tvDuracao.setText(String.format("%.2f", value));
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
