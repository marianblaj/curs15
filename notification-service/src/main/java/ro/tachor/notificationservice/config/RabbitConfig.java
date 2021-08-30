package ro.tachor.notificationservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
    @Bean
    DirectExchange productsExchange() {
        return new DirectExchange("products.exchange");
    }

    @Bean
    Queue productQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding binding(Queue productQueue, DirectExchange productsExchange) {
        return BindingBuilder.bind(productQueue).to(productsExchange).with("product");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
