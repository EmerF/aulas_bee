package com.ambev.techempowers.model;

import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private Date dataFabricacao;
    private int tempoValidade;

    private double preco;

    public Produto(int id, String nome, Date dataFabricacao, int tempoValidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.tempoValidade = tempoValidade;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}
