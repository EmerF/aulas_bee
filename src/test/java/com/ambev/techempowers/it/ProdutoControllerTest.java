package com.ambev.techempowers.it;

import com.ambev.techempowers.model.Cerveja;
import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.model.Tipo;
import com.ambev.techempowers.model.TipoProduto;
import com.ambev.techempowers.repository.ProdutoRepository;
import com.ambev.techempowers.repository.TipoProdutoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
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
        Produto cerveja = new Cerveja();
        cerveja.setNome("Cerveja Teste");
        cerveja.setDescricao("Cerveja de teste");
        cerveja.setPreco(5.99);
        ((Cerveja) cerveja).setTemAlcool(true);
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setDescricao("Nacional");

        tipoProdutoRepository.save(tipoProduto);
        cerveja.setTipo(tipoProduto);
        String produtoJson = objectMapper.writeValueAsString(cerveja);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(produtoJson))
                .andExpect(status().isOk());

        // Verifica se o produto foi cadastrado
        Produto produtoCerveja = produtoRepository.findByNome("Cerveja Teste").get(0);
        assert produtoCerveja != null;
        assert produtoCerveja.getNome().equals("Cerveja Teste");
    }

  /*  @Test
    public void testCadastrarProduto() throws Exception {
        String cerveja = "{\"nome\":\"Cerveja\",\"preco\":5.99}";
        String refrigerante = "{\"nome\":\"Refrigerante\",\"preco\":5.99}";
        String agua = "{\"nome\":\"Cerveja\",\"preco\":5.99}";

        cadastrarProduto(cerveja);
        cadastrarProduto(refrigerante);
        cadastrarProduto(agua);

        // Verifica se os produtos foram cadastrados

        Produto produtoCerveja = produtoRepository.findByNome("Cerveja");
        assert produtoCerveja != null;

        Produto produtoRefrigerante = produtoRepository.findByNome("Cerveja");
        assert produtoRefrigerante != null;

        Produto produtoAgua = produtoRepository.findByNome("Cerveja");
        assert produtoRefrigerante != null;


    }*/
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
