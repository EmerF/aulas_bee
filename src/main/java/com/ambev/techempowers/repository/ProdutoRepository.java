package com.ambev.techempowers.repository;

import com.ambev.techempowers.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findByNome(String nome);
    Produto findUmProdutoByNome(String nome);
    // Você pode adicionar métodos personalizados de consulta, se necessário
}
