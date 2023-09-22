package com.ambev.techempowers.it;

import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoRepository;
import com.ambev.techempowers.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import(ProdutoService.class) // Importa o repositório da classe Produto
public class ProdutoIntegrationTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void testSalvarProduto() {
        // Criar um novo produto
        Produto produto = new Produto();
        produto.setNome("Produto de Teste");
        produto.setPreco(99.99);

        // Salvar o produto no banco de dados
        Produto produtoSalvo = produtoService.salvarProduto(produto);

        // Verificar se o produto foi salvo com sucesso
        assertNotNull(produtoSalvo.getId());

        // Buscar o produto no banco de dados e verificar se os dados correspondem
        Produto produtoRecuperado = produtoService.findById(produtoSalvo.getId()).orElse(null);
        assertNotNull(produtoRecuperado);
        assertEquals("Produto de Teste", produtoRecuperado.getNome());
        assertEquals(99.99, produtoRecuperado.getPreco(), 0.001); // Usando delta para comparar valores double
    }

    // Você pode adicionar mais testes para outras operações, como atualização e exclusão.
}

