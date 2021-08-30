package com.tachor.tachor.events;

import com.tachor.tachor.authentication.appUser.AppUser;
import dto.AppUserApi;
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

    public void sendAppUserAddedEvent(AppUserApi appUserApi) {
        log.info("Sending " + appUserApi + " on route appUser");
        rabbitTemplate.convertAndSend(productExchange.getName(), "product", appUserApi);
    }
}

