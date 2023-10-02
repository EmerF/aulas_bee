package com.ambev.techempowers.repository;

import com.ambev.techempowers.model.TipoProduto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TipoProdutoRepository extends MongoRepository<TipoProduto, String> {
    TipoProduto findByDescricao(String descricao);
    // Métodos de consulta personalizados, se necessário
}
