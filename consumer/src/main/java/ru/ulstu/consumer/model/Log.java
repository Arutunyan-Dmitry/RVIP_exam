package ru.ulstu.consumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "t_log")
@Data
@Accessors(chain = true)
public class Log {
    @Id
    private Integer id;
    private String body;
    private Boolean is_Done;
    private String error;
    private String received;
}