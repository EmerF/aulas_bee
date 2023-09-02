package com.ambev.techempowers;

public class CadastroProduto {


    public String cadastrar(String cafe) {
        if(cafe.equals("erro")){
            return "erro";
        }
        return "cadastrado";
    }

    public String consultar(String hd) {
        return "hard";
    }
}
