package com.ambev.techempowers.model;

public class Eletronico extends ProdutoOld {
    private String modelo;
    private String marca;

    public Eletronico(String nome, double preco, String modelo, String marca) {
        super(nome, preco); // Chama o construtor da superclasse Produto
        this.modelo = modelo;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public double calcularPreco() {
        // preço vem da classe pai
        return getPreco() * 1.1;
    }
}
