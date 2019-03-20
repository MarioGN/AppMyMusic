package com.marioneto.appmymusic.bean;

public class Musica {
    private  int Id;
    private Genero genero;
    private String interprete;
    private String nome;
    private int ano;
    private double duracao;

    public Musica(int id, Genero genero, String interprete, String nome, int ano, double duracao) {
        Id = id;
        this.genero = genero;
        this.interprete = interprete;
        this.nome = nome;
        this.ano = ano;
        this.duracao = duracao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}
