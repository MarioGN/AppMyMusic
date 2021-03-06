package com.marioneto.appmymusic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.bean.Musica;
import com.marioneto.appmymusic.util.MusicaAdapter;
import com.marioneto.appmymusic.util.RepositorioMusicas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    private ListView listaCatalogo;

    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCatalogo = findViewById(R.id.lista_catalogo);
        RepositorioMusicas.iniciar();
        this.deserializarListaMusicas();
        this.deserializarListaGeneros();

        listaCatalogo.setAdapter(new MusicaAdapter(this, R.layout.item_lista,
                RepositorioMusicas.getCatalogo().getListaMusicas()));

        listaCatalogo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeMusicDialog(position);
                return false;
            }
        });

        listaCatalogo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CadastrarMusica.class);
                intent.putExtra("Musica", position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.serializarListaMusicas();
        this.serializarListaGeneros();
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

    private boolean removeMusicDialog(final int position) {
        Musica musica = RepositorioMusicas.getCatalogo().getListaMusicas().get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar exclusão");
        builder.setMessage("Deseja confirmar exclusão da música: " + musica.getNome());

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RepositorioMusicas.getCatalogo().getListaMusicas().remove(position);
                ((MusicaAdapter)listaCatalogo.getAdapter()).notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alert = builder.create();
        alert.show();

        return false;
    }

    private void serializarListaMusicas() {
        FileOutputStream fileOS = null;
        ObjectOutputStream objectOS;

        try {
            fileOS = openFileOutput("lista_musicas.dad", Context.MODE_PRIVATE);
            objectOS = new ObjectOutputStream(fileOS);

            for (Musica m : RepositorioMusicas.getCatalogo().getListaMusicas()) {
                objectOS.writeObject(m);
            }

            objectOS.close();
            fileOS.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deserializarListaMusicas() {
        FileInputStream fileIS = null;
        ObjectInputStream objectIS;

        try {
            fileIS = openFileInput("lista_musicas.dad");
            objectIS = new ObjectInputStream(fileIS);

            boolean read = true;
            while (read) {
                Musica m = null;

                try {
                    m = (Musica) objectIS.readObject();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                if (m != null) {
                    RepositorioMusicas.getCatalogo().getListaMusicas().add(m);
                }
                else {
                    read = false;
                }
            }

            objectIS.close();
            fileIS.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void serializarListaGeneros() {
        FileOutputStream fileOS = null;
        ObjectOutputStream objectOS;

        try {
            fileOS = openFileOutput("lista_generos.dad", Context.MODE_PRIVATE);
            objectOS = new ObjectOutputStream(fileOS);

            for (Genero g : RepositorioMusicas.getCatalogo().getListaGeneros()) {
                objectOS.writeObject(g);
            }

            objectOS.close();
            fileOS.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deserializarListaGeneros() {
        FileInputStream fileIS = null;
        ObjectInputStream objectIS;

        try {
            fileIS = openFileInput("lista_generos.dad");
            objectIS = new ObjectInputStream(fileIS);

            boolean read = true;
            while (read) {
                Genero g = null;

                try {
                    g = (Genero) objectIS.readObject();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                if (g != null) {
                    RepositorioMusicas.getCatalogo().getListaGeneros().add(g);
                }
                else {
                    read = false;
                }
            }

            objectIS.close();
            fileIS.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
