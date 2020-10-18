package com.secardia.todoapp.service;

import com.secardia.todoapp.entity.Task;
import com.secardia.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public void deleteTask(Long id) { taskRepository.deleteById(id); }

    public Task checkTask(Long id, Boolean checked) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("No task found with ID - " + id));
        task.setDone(checked);
        taskRepository.save(task);
        return task;
    }

}
