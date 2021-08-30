package ro.tachor.product.productservice.events;

import dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange productExchange;

    public void sendProductAddedEvent(Product product) {
        log.info("Sending " + product + " on route product");
        rabbitTemplate.convertAndSend(productExchange.getName(), "product", product);
    }
}
