package com.ambev.techempowers.model;

import com.ambev.techempowers.interfaces.CalcularAjudaCusto;
import com.ambev.techempowers.interfaces.VerificarFormacoes;

public abstract class Funcionario {
    private String nome;
    private String endereco;
    private String telefone;


    public abstract Double calcularBonus();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
