package com.marioneto.appmymusic.bean;

import java.io.Serializable;


public class Genero implements Serializable {
    private int id;
    private String nome;

    public Genero(int id, String descricao) {
        this.id = id;
        this.nome = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
