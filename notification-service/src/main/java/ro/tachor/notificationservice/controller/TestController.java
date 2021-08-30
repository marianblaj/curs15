package ro.tachor.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.tachor.notificationservice.service.NotificationService;

@RestController
@RequestMapping("testws")
@RequiredArgsConstructor
public class TestController {
    private final NotificationService notificationService;

    @GetMapping
    void sendws(){
        notificationService.send("test","hello");
    }
}
