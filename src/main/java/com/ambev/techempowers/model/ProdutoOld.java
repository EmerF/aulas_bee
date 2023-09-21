package com.ambev.techempowers.model;

public abstract class ProdutoOld {
    String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Método abstrato para calcular o preço
    public abstract double calcularPreco();
}
