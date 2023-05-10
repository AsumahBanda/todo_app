package com.example.to_do_app_backend.dto;

import com.example.to_do_app_backend.models.Task;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Data
public class TaskDto {
    private UUID id;

    private String title;

    private UUID userId;

    private String description;

    private Date dueDate;

    private boolean status;




    public TaskDto(UUID id, String title, UUID userId, String description, Date dueDate, boolean status) {
    this.title = title;
    this.userId = userId;
    this.description = description;
    this.dueDate = dueDate;
    this.status = status;
    this.id = id;
    }
    public Task toTask() {
        return new Task(id, title, userId,description, dueDate,status);
    }
}
