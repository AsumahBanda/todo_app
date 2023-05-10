package com.example.to_do_app_backend.controllers;
import com.example.to_do_app_backend.MyConstants;
import com.example.to_do_app_backend.dto.PaginationResponse;
import com.example.to_do_app_backend.dto.TaskDto;
import com.example.to_do_app_backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(MyConstants.tasksEndPoint)
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping
    public ResponseEntity<Map<String,Object>> getAllTasks(@RequestParam(defaultValue = "10") int size,
                                                          @RequestParam(defaultValue = "1") int page) {
       PaginationResponse<TaskDto> tasks = taskService.getAllTasks(page,size);

       if(tasks == null){
         return   ResponseEntity.noContent().build();
       }
        return ResponseEntity.ok(Map.of("data",tasks,"status","successful"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        Optional<TaskDto> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.orElse(null));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto reqTask) {

        TaskDto task = taskService.createTask(reqTask);

        if(task != null){
            ResponseEntity.ok(task);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> updateTask(@PathVariable Long id, @RequestBody TaskDto task) {
        Optional<TaskDto> taskTobeUpdated = taskService.updateTask(id,task);
        if (taskTobeUpdated.isEmpty()) {
            return ResponseEntity.ofNullable(
                    Map.of("message", "Something went wrong and update was not successful",
                            "Success", false));
        }
        return ResponseEntity.ok(Map.of("message",taskTobeUpdated, "Success",true));
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<List<TaskDto>>>getPeopleByParam(@RequestParam(value = "title",required = false) String name,
                                                    @RequestParam(value = "status",required = false) boolean status) {
        Optional<List<TaskDto>> tasks = taskService.getTasksByNameAndStatus(name, status);
        if(tasks.isEmpty()){
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }


    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.ok(Map.of("message","successful"));

    }

}
