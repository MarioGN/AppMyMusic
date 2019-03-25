package com.marioneto.appmymusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.bean.Musica;
import com.marioneto.appmymusic.util.RepositorioMusicas;

public class CadastrarMusica extends AppCompatActivity {
    private Spinner spnGenero;
    private SeekBar skAno, skDuracao;
    private TextView tvAno, tvDuracao;
    private double duracao;
    private EditText etInterprete, etNomeMusica;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_musica);

        spnGenero = findViewById(R.id.spn_genero);
        skAno = findViewById(R.id.sk_ano);
        tvAno = findViewById(R.id.tv_ano);
        skDuracao = findViewById(R.id.sk_duracao);
        tvDuracao = findViewById(R.id.tv_duracao);
        etInterprete = findViewById(R.id.et_interprete);
        etNomeMusica = findViewById(R.id.et_musica);
        btCadastrar = findViewById(R.id.btn_cadastrar_musica);

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

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Genero genero = (Genero) spnGenero.getSelectedItem();
                String interprete = etInterprete.getText().toString();
                String musica = etNomeMusica.getText().toString();
                int ano = Integer.parseInt(tvAno.getText().toString());
                double duracao = skDuracao.getProgress()/60;
                Musica novaMusica = new Musica(0, genero, interprete, musica, ano, duracao);

                RepositorioMusicas.getCatalogo().adicionarMusica(novaMusica);

                Toast.makeText(CadastrarMusica.this, "Nova música adicionada",
                        Toast.LENGTH_SHORT).show();


            }
        });
    }
}
