/*
package com.ambev.techempowers.it;

import com.ambev.techempowers.dto.ProdutoDTO;
import com.ambev.techempowers.model.Cerveja;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
import com.ambev.techempowers.repository.TipoProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@SpringBootTest(classes = TestMongoConfig.class)
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp() {
        // Limpar o banco de dados antes de cada teste
       produtoRepository.deleteAll();
    }
    @Test
    public void testRecursoNaoEncontrado() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/error")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void testCadastrarProdutoEVerificarCadastro() throws Exception {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("ProdutoIT");
        produtoDTO.setDescricao("ProdutoIT Descrição");
        produtoDTO.setPreco(9.99);
        String produtoJson = objectMapper.writeValueAsString(produtoDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isOk());

        // Verify if the product was saved in MongoDB
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos/consultar/{nome}", produtoDTO.getNome()))
                .andExpect(status().isOk())
                .andReturn();

        // Assuming your controller returns a JSON array
        String content = result.getResponse().getContentAsString();
        // Validate the content as needed
        // For example:
        assert content.contains(produtoDTO.getNome());
    }



    @Test
    public void testAtualizarProduto() throws Exception {
        // Cadastrar um produto para ser atualizado
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("ProdutoIT");
        produtoDTO.setDescricao("ProdutoIT Descrição");
        produtoDTO.setPreco(9.99);
        String produtoJson = objectMapper.writeValueAsString(produtoDTO);

        MvcResult cadastrarResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isOk())
                .andReturn();

        // Extrair o ID do produto cadastrado
        String id = objectMapper.readTree(cadastrarResult.getResponse().getContentAsString()).get("id").textValue();

        // Atualizar o produto
        ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();
        produtoAtualizadoDTO.setNome("ProdutoIT Atualizado");
        produtoAtualizadoDTO.setDescricao("ProdutoIT Descrição Atualizada");
        produtoAtualizadoDTO.setPreco(19.99);
        String produtoAtualizadoJson = objectMapper.writeValueAsString(produtoAtualizadoDTO);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/produtos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoAtualizadoJson))
                .andExpect(status().isOk());

        // Verificar se o produto foi atualizado no MongoDB
        MvcResult consultarResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos/{id}", id))
                .andExpect(status().isOk())
                .andReturn();

        Produto produtoAtualizado = objectMapper.readValue(consultarResult.getResponse().getContentAsString(), Produto.class);

        // Verificar se as informações foram atualizadas corretamente
        // Personalize isso com base nos campos do seu modelo
        assert produtoAtualizado.getNome().equals(produtoAtualizadoDTO.getNome());
        assert produtoAtualizado.getDescricao().equals(produtoAtualizadoDTO.getDescricao());
        //assert produtoAtualizado.getPreco().equals(produtoAtualizadoDTO.getPreco());
    }
    public void cadastrarProduto(String produtoJson) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos/cadastrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testConsultarProdutoPorNome() throws Exception {
        String nomeProduto = "Cerveja";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos/{nome}", nomeProduto)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Você pode adicionar verificações adicionais aqui com base na resposta JSON
    }

}

*/
