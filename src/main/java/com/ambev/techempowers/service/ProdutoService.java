package com.ambev.techempowers.service;

import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private ModelMapper modelMapper = new ModelMapper();

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

    public List<Produto> consultarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public ProdutoDTO convertToDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public Produto convertToProduto(ProdutoDTO produtoDTO) {
        return modelMapper.map(produtoDTO, Produto.class);
    }

    // Outros métodos de serviço, como buscar, atualizar e excluir produtos
}
