package com.yusuferdogan.todoapp.services;

import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// httpReq ----> controller -----> Service ---->  Repository
// frontEnd <---- controller <---- service <------

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return (taskRepository.findAll());
    }

    @Override
    public Iterable<Task> getAllTasksOfUser(String email,String password) {
        List<Task> tasksOfUser = new ArrayList<Task>();
        for(Task t:taskRepository.findAll()){
            if(t.getUser().getemail().equals(email) && t.getUser().getPassword().equals(password)){
                tasksOfUser.add(t);
            }
        }
        return tasksOfUser;
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateTask(Task task) {
         taskRepository.save(task);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void removeTask(Long id) {

        Optional<Task> task= taskRepository.findById(id);

        if(task.isPresent()) {
            taskRepository.delete(task.get());
        }

    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Long size(){
        return (taskRepository.count());
    }
}
