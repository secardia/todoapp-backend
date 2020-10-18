package com.secardia.todoapp.service;

import com.secardia.todoapp.entity.TasksList;

import com.secardia.todoapp.repository.TasksListRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksListService {

    private TasksListRepository tasksListRepository;

    public TasksListService(TasksListRepository tasksListRepository) {
        this.tasksListRepository = tasksListRepository;
    }

    public List<TasksList> getTasksLists() {
        return tasksListRepository.findAll();
    }

    public TasksList getTasksList(Long id) {
        return tasksListRepository.findById(id).orElseThrow(() -> new RuntimeException("No tasks list found with ID - " + id));
    }

    public TasksList saveTasksList(TasksList tasksList) {
        return tasksListRepository.save(tasksList);
    }

    public void deleteTasksList(Long tasksListId) {
        tasksListRepository.deleteById(tasksListId);
    }


    /*public Task checkTask(Long id, Boolean checked) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("No task found with ID - " + id));
        task.setDone(checked);
        taskRepository.save(task);
        return task;
    }*/
}
