package ro.tachor.notificationservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.tachor.notificationservice.model.Product;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {
    private final NotificationService notificationService;

    @RabbitListener(queues = "#{productQueue.name}")
    void processStudentEvent(Product event) {
        log.info("Received event in notificationService " + event);
        notificationService.send("product",event);
    }
}
