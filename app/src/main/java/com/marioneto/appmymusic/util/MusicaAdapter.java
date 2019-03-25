package com.marioneto.appmymusic.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.marioneto.appmymusic.R;
import com.marioneto.appmymusic.bean.Musica;

import java.util.List;

public class MusicaAdapter extends ArrayAdapter<Musica> {
    private int layout;

    public MusicaAdapter(Context context, int resource, List<Musica> musicas) {
        super(context, resource, musicas);
        this.layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout,parent,false);
        }

        TextView titulo = convertView.findViewById(R.id.item_titulo);
        TextView interprete = convertView.findViewById(R.id.item_interprete);
        TextView genero = convertView.findViewById(R.id.item_genero);

        Musica musica = this.getItem(position);
        titulo.setText(musica.getNome());
        interprete.setText(musica.getInterprete());
        genero.setText(musica.getGenero().getNome());

        return convertView;
    }
}
