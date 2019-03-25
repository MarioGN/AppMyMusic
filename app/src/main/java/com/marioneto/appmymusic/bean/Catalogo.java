package com.marioneto.appmymusic.bean;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Musica> listaMusicas;
    private List<Genero> listaGeneros;

    public Catalogo() {

        this.listaMusicas = new ArrayList();
        this.listaGeneros = new ArrayList();
    }

    public boolean adicionarMusica(Musica musica) {
        listaMusicas.add(musica);
        return true;
    }

    public boolean adicionarGenero(Genero genero) {
        listaGeneros.add(genero);
        return true;
    }

    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }

    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }
}
