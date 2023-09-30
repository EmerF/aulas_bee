package com.ambev.techempowers.model;

public class Gerente extends  Funcionario{
    private double salario;
    @Override
    public Double calcularBonus() {
        return salario * 0.05;
    }
}
