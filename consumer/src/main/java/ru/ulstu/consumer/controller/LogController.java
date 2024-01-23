package ru.ulstu.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ulstu.consumer.model.Log;
import ru.ulstu.consumer.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("")
    public List<Log> getLog() {
        return logService.findAllLogs();
    }
}