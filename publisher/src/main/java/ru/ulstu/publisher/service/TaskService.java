package ru.ulstu.publisher.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.ulstu.publisher.dto.TaskDto;
import ru.ulstu.publisher.models.Task;
import ru.ulstu.publisher.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchangeName;
    private static int counter = 0;
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task sendTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(counter++);
        task.setBody(taskDto.getBody());
        task.setCreated(LocalDateTime.now().toString());
        try {
             rabbitTemplate.convertAndSend(exchangeName, "", taskDto.getBody());
             task.setIs_Sent(true);
        } catch (Exception e) {
            task.setIs_Sent(false);
            task.setError(e.getMessage());
        }
        return taskRepository.save(task);
    }
}
