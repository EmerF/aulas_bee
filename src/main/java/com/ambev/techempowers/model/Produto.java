package com.ambev.techempowers.model;

import com.ambev.techempowers.interfaces.Gerenciavel;
import com.ambev.techempowers.interfaces.Perecivel;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto implements Perecivel, Gerenciavel {
    @Id
    private String id;
    private String nome;
    private double preco;

    private Tipo tipo;

    @Override
    public double calcularPreco() {
        return 0;
    }

    @Override
    public void exibirDetalhes() {

    }

    @Override
    public boolean verificarSeEstaVencido() {
        return false;
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    // getters e setters
}