package com.marioneto.appmymusic.util;

import com.marioneto.appmymusic.bean.Catalogo;
import com.marioneto.appmymusic.bean.Genero;
import com.marioneto.appmymusic.bean.Musica;

public class RepositorioMusicas {
    static private final Catalogo catalogo = new Catalogo();

    private RepositorioMusicas() {
    }

    static public void iniciar() {
        Genero genero = new Genero(1, "Rock");

        catalogo.adicionarMusica(new Musica(1, genero, "Foo Fighters",
                "Everlong", 1997,  4.50));
        catalogo.adicionarMusica(new Musica(1, genero, "Foo Fighters",
            "In the lcear", 2014,  4.05));
    }

    public static Catalogo getCatalogo() {
        return catalogo;
    }
}
