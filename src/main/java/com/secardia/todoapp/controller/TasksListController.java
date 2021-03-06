package com.secardia.todoapp.controller;

import com.secardia.todoapp.entity.Task;
import com.secardia.todoapp.entity.TasksList;
import com.secardia.todoapp.links.TasksListLinks;
import com.secardia.todoapp.service.TasksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TasksListController {

    @Autowired
    TasksListService tasksListService;

    // Return all the tasks lists
    @GetMapping(path = TasksListLinks.LIST_TASKSLISTS)
    public ResponseEntity<List<TasksList>> listTasksLists() {
        List<TasksList> resource = tasksListService.getTasksLists();
        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    // Save and return the tasks list
    @PostMapping(path = TasksListLinks.SAVE_TASKSLIST)
    public ResponseEntity<TasksList> saveTasksList(@RequestBody TasksList tasksList) {
        TasksList resource = tasksListService.saveTasksList(tasksList);
        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    // Deletethe tasks list
    @DeleteMapping(path = TasksListLinks.DELETE_TASKSLIST)
    public ResponseEntity<Void> deleteTask(@RequestParam Long tasksListId) {
        tasksListService.deleteTasksList(tasksListId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
