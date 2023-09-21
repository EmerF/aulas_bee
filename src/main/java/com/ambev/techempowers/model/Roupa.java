package com.ambev.techempowers.model;

public class Roupa  extends Produto{
    private String tamanho;
    private String tipoTecido;
    private String marca;
    private String cor;

    public Roupa(String nome, double preco) {
        super(nome, preco);
        // ajustar construtor..
    }



    @Override
    public double calcularPreco() {
        return 0;
    }
}
