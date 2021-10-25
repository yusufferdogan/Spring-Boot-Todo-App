package com.yusuferdogan.todoapp.services;

import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.domain.User;

public interface UserService {

    public void addUser(User user);

    public void removeUser(Long id);

    Iterable<User> getAllUsers();

    boolean isUserExist(Long id);

    public boolean isUserExist(String email);

    User getUserByEmailAndPassword(String email,String password);


    }
