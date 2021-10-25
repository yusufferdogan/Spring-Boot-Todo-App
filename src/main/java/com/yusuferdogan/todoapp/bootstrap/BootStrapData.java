package com.yusuferdogan.todoapp.bootstrap;

import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final TaskRepository taskRepository;

    public BootStrapData(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        for(Task t:taskRepository.findAll()){
            System.out.println(t.toString());
        }
    }
}
