package com.example.to_do_app_backend.models;


import com.example.to_do_app_backend.dto.TaskDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table
public class Task {
    @Id
    //@GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "user_id")
    private UUID userId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date due_date;

    @Column(nullable = false)
    private boolean status;

    public Task(){}

    public Task(UUID id, String title, UUID userId, String description, Date dueDate, boolean status) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.description = description;
        this.due_date = dueDate;
        this.status = status;
    }

    public   TaskDto toDto(){
        return new TaskDto(id, title, userId,description,due_date,status);
    }


    // Constructors, getters, and setters
    // ...

}
