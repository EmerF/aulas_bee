package com.ambev.techempowers.repository;

import com.ambev.techempowers.model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProdutoDAO {
    Connection conn;
    private MYSQLConn mysqlConn = new MYSQLConn("seu_usuario","sua_senha","jdbc:mysql://localhost:3306/seu_banco_de_dados");

    public int salvarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        //DriverManager.getConnection(url, usuario, senha
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, produto.getNome());
        pstmt.setDouble(2, produto.getPreco());
        return pstmt.executeUpdate();

    }

        public void criarConexao() throws SQLException {
            conn = mysqlConn.createConnection();
        }

        public void fecharConexao() throws SQLException {
            this.conn.close();
        }
    }



