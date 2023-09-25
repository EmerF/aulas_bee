package com.ambev.techempowers.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConn {
    public MYSQLConn(String usuario,  String senha, String url) {
        this.usuario = usuario;
        this.senha = senha;
        this.url = url;
    }

    private String usuario;
    private String url;
    private String senha;

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}
