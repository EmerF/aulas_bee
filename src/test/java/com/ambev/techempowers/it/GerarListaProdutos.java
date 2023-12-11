package com.ambev.techempowers.it;

import com.ambev.techempowers.dto.ProdutoDTO;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerarListaProdutos {

    List<ProdutoDTO> produtos;

    @PostConstruct
    public void init() {
        // Criar uma lista de 5000 produtos de exemplo
        produtos = criarProdutosDeExemplo();

    }


    public List<ProdutoDTO> buscarProdutosPorNome(String nome) {

        return produtos.stream()
                .filter(produto -> produto.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    public List<ProdutoDTO> filtrarProdutosPorPreco(double valorMinimo) {
        return produtos
                .stream()
                .filter(produto -> produto.getPreco() > valorMinimo)
                .collect(Collectors.toList());
    }

    private List<ProdutoDTO> criarProdutosDeExemplo() {
        // Lógica para criar 5000 produtos de exemplo
        // Esta lógica pode ser ajustada conforme necessário para sua aplicação
        // Aqui, estou apenas criando produtos fictícios para fins de exemplo

        // Lista para armazenar os produtos
        produtos = new ArrayList<>();

        for (int i = 1; i <= 5000; i++) {
            ProdutoDTO produto = new ProdutoDTO();
            produto.setNome("Produto: " + i);
            produto.setDescricao("Descrição do Produto: " + i);
            produto.setPreco(10.0 * i);  // Preço fictício baseado no índice

            produtos.add(produto);
        }

        return produtos;
    }
}
