package fr.rekla.notification.controller;

import fr.rekla.notification.entities.Message;
import fr.rekla.notification.service.TwilioNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/notifications")
public class TwilioNotificationController {

    private final TwilioNotificationService twilioNotificationService;

    public TwilioNotificationController(TwilioNotificationService twilioNotificationService) {
        this.twilioNotificationService = twilioNotificationService;
    }

    @PostMapping("/sendSMS")
    public ResponseEntity<String> sendSMS(@RequestBody Message message) {
        twilioNotificationService.sendSMS(message.getBody());
        return new ResponseEntity<>(message.getBody(), HttpStatus.OK);
    }

    @RabbitListener(queues = "customerQueue", ackMode = "AUTO")
    public void listen(String message) {
        log.info("Message read from customerQueue : {}", message);
        twilioNotificationService.sendSMS(message);
    }
}
