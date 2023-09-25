package com.ambev.techempowers.model;

import java.util.Date;

public class Refrigerante extends Produto{

    private boolean contemAcucar;
    public Refrigerante(int id, String nome, Date dataFabricacao, int tempoValidade, double preco) {
        super(id, nome, dataFabricacao, tempoValidade, preco);
    }
}
