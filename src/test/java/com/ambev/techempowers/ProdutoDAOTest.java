package com.ambev.techempowers;

import com.ambev.techempowers.model.Produto;
import com.ambev.techempowers.repository.ProdutoDAO;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;

public class ProdutoDAOTest {

    @BeforeAll
    void setup(){
        // crio container para subir o MYSQL...
    }

    @Test
    public void testSalvarProduto() throws SQLException {
        // criar o produto
        Produto produto = new Produto(1, "Produto de Teste", new Date(),6, 99.99);

        // criar o produtoDao
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // criar conexão()
        produtoDAO.criarConexao();

        // persistir os dados
        int idProd = produtoDAO.salvarProduto(produto);
        assertNotNull(idProd);

        // fechar conexão
        produtoDAO.fecharConexao();

    }
}
