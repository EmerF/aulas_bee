package com.ambev.techempowers.dto;

import com.ambev.techempowers.model.Produto;
import org.modelmapper.ModelMapper;

public class ProdutoDTOConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public ProdutoDTO convertToDTO(Produto produto) {
        return modelMapper.map(produto, ProdutoDTO.class);
    }
}
