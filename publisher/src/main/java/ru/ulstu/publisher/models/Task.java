package ru.ulstu.publisher.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "t_task")
@Data
@Accessors(chain = true)
public class Task {
    @Id
    private Integer id;
    private String body;
    private Boolean is_Sent;
    private String error;
    private String created;
}