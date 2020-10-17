package com.secardia.todoapp.service;

import com.secardia.todoapp.entity.Task;
import com.secardia.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

}
