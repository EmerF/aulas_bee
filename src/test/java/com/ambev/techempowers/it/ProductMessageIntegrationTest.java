/*
package com.ambev.techempowers.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestPropertySource;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.rabbitmq.port=5672", // RabbitMQ Test Container port
        "spring.rabbitmq.host=localhost" // RabbitMQ Test Container hostname
})
@AutoConfigureStubRunner
public class ProductMessageIntegrationTest {

    @Autowired
    private StubTrigger stubTrigger;

    @Test
    public void testProductMessageSentToTopic() {
        // Simulate sending a message to the topic using a stub trigger
        Message<String> message = MessageBuilder.withPayload("Product saved successfully")
                .setHeader("routingKey", "product.saved")
                .build();
        stubTrigger.trigger("trigger-product-saved", message);

        // Verify if the message was sent to the RabbitMQ topic
        await().untilAsserted(() -> {
            // Implement logic to verify the message in the RabbitMQ topic.
            // You may use RabbitMQ client libraries to consume messages and assert their content.
            // Example: Use Spring AMQP's RabbitTemplate to consume messages from the topic.
            // RabbitTemplate rabbitTemplate = ... (autowire RabbitTemplate)
            // String receivedMessage = rabbitTemplate.receiveAndConvert("product-topic");

            // Assertion
            // assertThat(receivedMessage).isEqualTo("Product saved successfully");
        });
    }
}
*/
