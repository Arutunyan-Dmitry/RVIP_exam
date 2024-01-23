package ru.ulstu.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.consumer.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {

}
