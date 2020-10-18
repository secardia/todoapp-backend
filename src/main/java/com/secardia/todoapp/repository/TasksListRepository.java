package com.secardia.todoapp.repository;

import com.secardia.todoapp.entity.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksListRepository extends JpaRepository<TasksList, Long> {}
