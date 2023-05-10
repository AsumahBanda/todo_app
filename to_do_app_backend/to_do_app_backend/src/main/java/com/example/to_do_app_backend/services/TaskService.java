package com.example.to_do_app_backend.services;
import com.example.to_do_app_backend.dto.PaginationResponse;
import com.example.to_do_app_backend.dto.TaskDto;
import com.example.to_do_app_backend.models.Task;
import com.example.to_do_app_backend.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public PaginationResponse<TaskDto> getAllTasks(int size, int page) {
        page =page-1;
        if(page <0) page=0;
        Page<Task> data = taskRepository.findAll(PageRequest.of(size,page, Sort.by(Sort.Direction.ASC,"title")));
        List<TaskDto> tasks = data.map(Task::toDto).toList();

     return new PaginationResponse<>(tasks, data.getSize(), data.getNumber(), data.getTotalPages(), data.getTotalElements());
    }

    public Optional<TaskDto> getTaskById(Long id) {

         Optional<Task> taskDto = taskRepository.findById(id);
        return taskDto.map(Task::toDto);
    }
    public TaskDto createTask(TaskDto taskDto) {
        taskDto.setId(UUID.randomUUID());
        return taskRepository.save(taskDto.toTask()).toDto();
    }
    public Optional<TaskDto> updateTask(Long searchId, TaskDto queryTask) {
        Optional<Task> oldNullableTask = taskRepository.findById(searchId);
        if (oldNullableTask.isEmpty()) {
            return Optional.empty();
        }
        Task oldTask = oldNullableTask.get();

        String title = queryTask.getTitle() != null && !queryTask.getTitle().isBlank() ?
                queryTask.getTitle() : oldTask.getTitle();
        String description = queryTask.getDescription() != null && !queryTask.getDescription().isBlank() ?
                queryTask.getDescription() : oldTask.getDescription();
        boolean status = queryTask.isStatus() || oldTask.isStatus();
        UUID id = oldTask.getId();
        Date dueDate = queryTask.toTask().getDue_date() != null ?
                queryTask.toTask().getDue_date() : oldTask.getDue_date();
        UUID userId = oldTask.getUserId();

        Task taskToBeUpdated = new Task(id, title, userId, description, dueDate, status);
        return Optional.of(taskRepository.save(taskToBeUpdated).toDto());
    }
    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(tasks -> taskRepository.delete(tasks));
    }

 public    Optional<List<TaskDto>> getTasksByNameAndStatus(String title, Boolean  status){
        List<TaskDto>  tasks =   taskRepository.findByTitleAndStatus(title,status).stream().map(Task::toDto).toList();
        return Optional.of(tasks);
    }
    public    Optional<List<TaskDto>> getTaskByUserId(Long userId){
        List<TaskDto>  tasks =   taskRepository.findByUserId(userId).stream().map(Task::toDto).toList();
        return Optional.of(tasks);
    }

}
