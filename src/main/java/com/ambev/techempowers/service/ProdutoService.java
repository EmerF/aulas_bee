package com.ambev.techempowers.service;

import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO convertToDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public Produto convertToProduto(ProdutoDTO produtoDTO) {
        return modelMapper.map(produtoDTO, Produto.class);
    }


    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = convertToProduto(produtoDTO);
        return convertToDTO(produtoRepository.save(produto));
    }

    public Optional<Produto> findById(String id) {
        produtoRepository.findByNome(id);
        return produtoRepository.findById(id);

    }

    public List<ProdutoDTO> consultarPorNome(String nome) {
        List<Produto> listaProdutosPorNome = produtoRepository.findByNome(nome);
        List<ProdutoDTO> listaDTO = listaProdutosPorNome.stream()
                .map(source -> modelMapper.map(source, ProdutoDTO.class))
                .collect(Collectors.toList());
        return listaDTO;
    }

    public ProdutoDTO atualizarProduto(String id, ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoRepository.findById(id).
                orElse(null);
        if(produtoExistente != null){
            produtoExistente.setNome(produtoDTO.getNome());
            produtoExistente.setDescricao(produtoDTO.getDescricao());
            produtoExistente.setPreco(produtoDTO.getPreco());

            return convertToDTO(produtoRepository.save(produtoExistente));
        } else {
            return null;
        }

    }

    public boolean deletarProduto(String id) {
        produtoRepository.deleteById(id);
        Optional<Produto> produto = produtoRepository.findById(id);

        return produto.isPresent();
    }


    // Outros métodos de serviço, como buscar, atualizar e excluir produtos
}
