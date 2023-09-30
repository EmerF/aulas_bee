package com.ambev.techempowers.model;

public class Vendedor extends  Funcionario{
    private double totalVendas;
    @Override
    public Double calcularBonus() {
        return totalVendas * 0.10 ;
    }
}
