package com.ambev.techempowers.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "aguas")
public class Agua extends Produto{

    private boolean temGas;

    public boolean isTemGas() {
        return temGas;
    }

    public void setTemGas(boolean temGas) {
        this.temGas = temGas;
    }
}
