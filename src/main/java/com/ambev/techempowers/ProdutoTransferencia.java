package com.ambev.techempowers;

import com.ambev.techempowers.model.Produto;

import java.util.Date;

public class ProdutoTransferencia extends Produto {
    private String notaFiscalEntrada;
    private String cidadeOrigem;

    private String cidadeDestino;
    public ProdutoTransferencia(int id, String nome, Date dataFabricacao, int tempoValidade, double preco) {
        super(id, nome, dataFabricacao, tempoValidade, preco);
    }


}
