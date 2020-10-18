package com.secardia.todoapp.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TasksList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tasksListId;
    private String name;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Task> tasksList;

    public Long getTasksListId() {
        return tasksListId;
    }

    public void setTasksListId(Long tasksListId) {
        this.tasksListId = tasksListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(ArrayList<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public void addTask(Task task) {
        this.tasksList.add(task);
    }
}
