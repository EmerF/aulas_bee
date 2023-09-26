package com.ambev.techempowers.model;

import java.util.Date;

public class ProdutoInterno extends Produto{

    private String notaFiscalEntrada;
    private String cidadeOrigem;


    public ProdutoInterno(int id, String nome, Date dataFabricacao, int tempoValidade, double preco) {
        super(id, nome, dataFabricacao, tempoValidade, preco);
    }


}
