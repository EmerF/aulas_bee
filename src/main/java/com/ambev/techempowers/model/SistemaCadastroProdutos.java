package com.ambev.techempowers.model;

public class SistemaCadastroProdutos {
    public static void main(String[] args) {
        Eletronico celular = new Eletronico("Smartphone", 799.99, "iPhone 13", "Apple");
        Alimento chocolate = new Alimento("Chocolate", 4.99, "31/12/2023");

        // Acesso aos atributos e métodos das subclasses
        System.out.println("Produto: " + celular.getNome() + " - Modelo: " + celular.getModelo());
        System.out.println("Produto: " + chocolate.getNome() + " - Data de Validade: " + chocolate.getDataValidade());
    }
}