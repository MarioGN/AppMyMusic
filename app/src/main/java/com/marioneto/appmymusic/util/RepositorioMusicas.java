package com.marioneto.appmymusic.util;

import com.marioneto.appmymusic.bean.Catalogo;
import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.bean.Musica;

public class RepositorioMusicas {
    static private final Catalogo catalogo = new Catalogo();

    private RepositorioMusicas() {
    }

    static public void iniciar() {
    }

    public static Catalogo getCatalogo() {
        return catalogo;
    }
}
