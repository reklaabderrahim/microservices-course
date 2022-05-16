package fr.rekla.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("customerQueue", message);
    }
}
