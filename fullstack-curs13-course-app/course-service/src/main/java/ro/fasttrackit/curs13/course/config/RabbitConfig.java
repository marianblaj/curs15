package ro.fasttrackit.curs13.course.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    FanoutExchange studentExchange() {
        return new FanoutExchange("students.exchange");
    }

    @Bean
    Queue studentQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding binding(Queue studentQueue, FanoutExchange studentExchange) {
        return BindingBuilder.bind(studentQueue).to(studentExchange);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
