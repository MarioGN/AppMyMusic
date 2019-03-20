package com.marioneto.appmymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Musica> listaMusicas;

    public Catalogo() {
        this.listaMusicas = new ArrayList();
    }

    public boolean adicionarMusica(Musica musica) {
        listaMusicas.add(musica);
        return true;
    }

    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }
}
