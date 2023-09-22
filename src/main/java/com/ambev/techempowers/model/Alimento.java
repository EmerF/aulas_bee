package com.ambev.techempowers.model;

public class Alimento extends ProdutoOld {
    private String dataValidade;

    public Alimento(String nome, double preco, String dataValidade) {
        super(nome, preco); // Chama o construtor da superclasse Produto
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    @Override
    public double calcularPreco() {
        return getPreco(); // Preço de alimentos não sofre alteração
    }
}
