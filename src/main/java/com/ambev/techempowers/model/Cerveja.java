package com.ambev.techempowers.model;

import java.util.Date;

public class Cerveja extends Produto{

    private String cidadeFabricao;

    public Cerveja(int id, String nome, Date dataFabricacao, int tempoValidade, double preco) {
        super(id, nome, dataFabricacao, tempoValidade, preco);
    }
}
