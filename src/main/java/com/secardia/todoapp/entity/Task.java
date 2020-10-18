package com.secardia.todoapp.entity;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskToDo;

    private Boolean done = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskToDo() {
        return taskToDo;
    }

    public void setTaskToDo(String taskToDo) {
        this.taskToDo = taskToDo;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
