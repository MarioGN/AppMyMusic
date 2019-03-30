package com.marioneto.appmymusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.util.RepositorioMusicas;

public class CadastrarGenero extends AppCompatActivity {
    private EditText etGenero;
    private Button btCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_genero);

        etGenero = findViewById(R.id.et_genero);
        btCadastrar = findViewById(R.id.btn_cadastrar_genero);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoGenero = etGenero.getText().toString();

                if(!novoGenero.isEmpty()) {
                    RepositorioMusicas.getCatalogo()
                            .getListaGeneros().add(new Genero(0, novoGenero));

                    Toast.makeText(CadastrarGenero.this, "Dados salvos com sucesso!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(CadastrarGenero.this,
                            "Atenção, informe o nome do novo gênero musical para prosseguir.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
