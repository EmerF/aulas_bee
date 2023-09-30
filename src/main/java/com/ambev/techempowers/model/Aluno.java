package com.ambev.techempowers.model;

import com.ambev.techempowers.interfaces.CalcularAjudaCusto;
import com.ambev.techempowers.interfaces.VerificarFormacoes;

public class Aluno implements CalcularAjudaCusto, VerificarFormacoes {
    private String id;
    private String nome;
    private String telefone;

    @Override
    public double calcularAjudaDeCusto() {
        return 0;
    }

    @Override
    public double buscarFormacoes() {
        return 0;
    }
}
