package com.secardia.todoapp.service;

import com.secardia.todoapp.entity.Task;
import com.secardia.todoapp.entity.TasksList;

import com.secardia.todoapp.repository.TasksListRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TasksListService {

    private TasksListRepository tasksListRepository;

    public TasksListService(TasksListRepository tasksListRepository) {
        this.tasksListRepository = tasksListRepository;
    }

    // Return all the tasks lists
    public List<TasksList> getTasksLists() {
        return tasksListRepository.findAll();
    }

    // Return the tasks list with given id
    public TasksList getTasksList(Long id) {
        return tasksListRepository.findById(id).orElseThrow(() -> new RuntimeException("No tasks list found with ID - " + id));
    }

    // Save and return the tasks list
    public TasksList saveTasksList(TasksList tasksList) {
        return tasksListRepository.save(tasksList);
    }

    // Deletethe tasks list
    public void deleteTasksList(Long tasksListId) {
        tasksListRepository.deleteById(tasksListId);
    }

}
