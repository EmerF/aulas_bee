package com.ambev.techempowers.model;

import com.ambev.techempowers.interfaces.CalculadoraDesconto;

public class CalcularDescontoMae implements CalculadoraDesconto{

    @Override
    public Double calcularDescontoPorEvento() {
        return 0.10;
    }
}
