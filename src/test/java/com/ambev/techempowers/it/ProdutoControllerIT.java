package com.ambev.techempowers.it;


import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.repository.ProdutoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = TestMongoConfig.class)
public class ProdutoControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private String produtoJson;

    private ProdutoDTO produtoDTO ;
    private ProdutoDTO produtoDTOReturn;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        produtoRepository.deleteAll();
        criarProdutoDeTeste();
    }

    @Test
    public void testCadastrarProdutoEVerificar() throws Exception {

        criarProdutoNaBase();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/produtos/consultar/{nome}",
                                produtoDTO.getNome()))
                .andExpect(status().isOk())
                .andReturn();

        String produtoRet = result.getResponse().getContentAsString();
        assert produtoRet.contains(produtoDTO.getNome());

    }

    @Test
    public void testDeletarUmProduto() throws Exception {
        criarProdutoNaBase();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/produtos/{id}", produtoDTOReturn.getId()))
                .andExpect(status().isOk())
                .andReturn();
        String ret = result.getResponse().getContentAsString();
        assert ret.contains("Produto deletado");

    }

    private void criarProdutoNaBase() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isOk())
                .andReturn();
        produtoDTOReturn = objectMapper.readValue(result.getResponse().getContentAsString(), ProdutoDTO.class);

    }

    private void criarProdutoDeTeste() throws JsonProcessingException {
        produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("ProdutoIT");
        produtoDTO.setDescricao("ProdutoIT descrição");
        produtoDTO.setPreco(1.99);

        produtoJson = objectMapper.writeValueAsString(produtoDTO);

    }


}
