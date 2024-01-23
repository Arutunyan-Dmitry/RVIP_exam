package ru.ulstu.publisher.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ulstu.publisher.dto.TaskDto;
import ru.ulstu.publisher.models.Task;
import ru.ulstu.publisher.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("")
    public List<Task> getTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping("/")
    public Task sendTask(@RequestBody TaskDto taskDto)
    {
        return taskService.sendTask(taskDto);
    }
}
