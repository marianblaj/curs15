package ro.tachor.product.productservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    private final ConnectionFactory connectionFactory;

    @Bean
    DirectExchange productsExchange() {
        return new DirectExchange("products.exchange");
    }

    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

}



//
//@Configuration
//public class RabbitConfig {
//
//    @Bean
//    FanoutExchange productExchange() {
//        return new FanoutExchange("products.exchange");
//    }
//
//    @Bean
//    Queue productQueue() {return new AnonymousQueue();}
//
//    @Bean
//    Binding binding(Queue productQueue, FanoutExchange productExchange) {
//        return BindingBuilder.bind(productQueue).to(productExchange);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//}
