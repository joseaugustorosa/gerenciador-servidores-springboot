package com.jose.servermanager.model;

public class Servidor {
    private int id;
    private String nome;
    private String descricao;
    private double capacidade;
    private boolean ativo;

    public Servidor(int id, String nome, String descricao, double capacidade, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.ativo = ativo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
