package com.marioneto.appmymusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.marioneto.appmymusic.util.MusicaAdapter;
import com.marioneto.appmymusic.util.RepositorioMusicas;

public class MainActivity extends AppCompatActivity {
    private ListView listaCatalogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCatalogo = findViewById(R.id.lista_catalogo);
        RepositorioMusicas.iniciar();
        listaCatalogo.setAdapter(new MusicaAdapter(this, R.layout.item_lista,
                RepositorioMusicas.getCatalogo().getListaMusicas()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MusicaAdapter)listaCatalogo.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.genero:
                startActivity(new Intent(this, CadastrarGenero.class));
                return true;
            case R.id.musica:
                startActivity(new Intent(this, CadastrarMusica.class));
                return true;
            default:
                return true;
        }
    }
}
