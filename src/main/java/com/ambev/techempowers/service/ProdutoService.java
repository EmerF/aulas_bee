package com.ambev.techempowers.service;

import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }



    public Optional<Produto> findById(String id) {
        return produtoRepository.findById(id);

    }

    // Outros métodos de serviço, como buscar, atualizar e excluir produtos
}
