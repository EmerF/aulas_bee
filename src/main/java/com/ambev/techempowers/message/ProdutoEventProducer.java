package com.ambev.techempowers.message;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEventProducer {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public ProdutoEventProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendProductSavedEvent(String productName) {
        String message = productName + " salvo com sucesso";
        amqpTemplate.convertAndSend("product-exchange", "product.saved", message);
    }
}
