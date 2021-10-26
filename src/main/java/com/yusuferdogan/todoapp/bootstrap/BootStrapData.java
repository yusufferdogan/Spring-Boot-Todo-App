package com.yusuferdogan.todoapp.bootstrap;

import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.domain.User;
import com.yusuferdogan.todoapp.repositories.TaskRepository;
import com.yusuferdogan.todoapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public BootStrapData(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

//        for(User t:userRepository.findAll()){
//            System.out.println(t.toString());
//        }
//        Optional<User> user1 = userRepository.findById(4L);
//        Optional<User> user2 = userRepository.findById(5L);
//        Optional<User> user3 = userRepository.findById(6L);
//
//        user1.ifPresent(userRepository::delete);
//        user2.ifPresent(userRepository::delete);
//        user3.ifPresent(userRepository::delete);


    }
}
