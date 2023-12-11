package com.ambev.techempowers.it;

import com.ambev.techempowers.dto.ProdutoDTO;

import java.util.List;

public class TestGerarListaProdutos {

    public static void main(String[] args) {
        GerarListaProdutos gerador = new GerarListaProdutos();

        // Initialize the list of products
        gerador.init();

        // Test searching products by name
        String nomeParaBuscar = "Produto1";
        List<ProdutoDTO> produtosPorNome = gerador.buscarProdutosPorNome(nomeParaBuscar);
        System.out.println("Produtos com nome contendo '" + nomeParaBuscar + "':");
        produtosPorNome
                .forEach(produto -> System.out.println(produto.getNome()));

        System.out.println();

        // Test filtering products by price
        double valorMinimo = 50.0;
        List<ProdutoDTO> produtosPorPreco = gerador.filtrarProdutosPorPreco(valorMinimo);
        System.out.println("Produtos com preço superior a " + valorMinimo + ":");
        produtosPorPreco.forEach(produto -> System.out.println(produto.getNome()));
    }
}

