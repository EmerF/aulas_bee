package com.ambev.techempowers.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private double preco;

    // getters e setters
}