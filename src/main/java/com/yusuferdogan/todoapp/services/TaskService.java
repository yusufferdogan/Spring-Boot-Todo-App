package com.yusuferdogan.todoapp.services;

import com.yusuferdogan.todoapp.domain.Task;

import java.util.List;
import java.util.Optional;


public interface TaskService {

    Iterable<Task> getAllTasks();

    Iterable<Task> getAllTasksOfUser(String email,String password);

    Optional<Task> getTaskById(Long id);

    void updateTask(Task task);

    void addTask(Task task);

    void removeTask(Long id);

    void saveTask(Task task);

    public Long size();
}
