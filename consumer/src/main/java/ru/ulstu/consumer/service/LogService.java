package ru.ulstu.consumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.ulstu.consumer.model.Log;
import ru.ulstu.consumer.repository.LogRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private static int counter = 0;
    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void taskListener(String message) {
        Log log = new Log();
        log.setId(counter++);
        log.setReceived(LocalDateTime.now().toString());
        try {
            log.setBody(message);
            log.setIs_Done(true);
        } catch (Exception e) {
            log.setError(e.getMessage());
            log.setIs_Done(true);
        }
        logRepository.save(log);
    }
}
