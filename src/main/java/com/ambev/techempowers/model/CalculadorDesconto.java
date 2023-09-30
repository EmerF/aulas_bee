package com.ambev.techempowers.model;

public class CalculadorDesconto {
    public double calcularPercentualDesconto(String tipoEvento){

        if(tipoEvento.equals("BF")){
            return 0.10;
        } else if(tipoEvento.equals("Mae")){
            return 0.15;

        } else if(tipoEvento.equals("Pai")){
            return 0.05;
        }
      return 0;
    }

}
