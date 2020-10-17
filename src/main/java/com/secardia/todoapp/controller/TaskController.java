package com.secardia.todoapp.controller;

import com.secardia.todoapp.entity.Task;
import com.secardia.todoapp.links.TaskLinks;
import com.secardia.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(path = TaskLinks.LIST_TASKS)
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> resource = taskService.getTasks();
        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    @PostMapping(path = TaskLinks.ADD_TASK)
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task resource = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }

    @DeleteMapping(path = TaskLinks.DELETE_TASK)
    public ResponseEntity<Void> deleteTask(@RequestParam Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
