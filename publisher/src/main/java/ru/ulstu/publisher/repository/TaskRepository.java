package ru.ulstu.publisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.publisher.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
