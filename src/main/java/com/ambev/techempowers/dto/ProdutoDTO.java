package com.ambev.techempowers.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoDTO {

    private String id;
    @NotBlank(message = "Informe o nome do produto")
    private String nome;
    @Size(min = 10, message = "Descrição deve ter no mínimo 10 caracteres")
    private String descricao;
    @DecimalMin(value = "1", message = "O preço dever ser maior que 1")
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
