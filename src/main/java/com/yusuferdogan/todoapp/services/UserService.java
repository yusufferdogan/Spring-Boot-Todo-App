package com.yusuferdogan.todoapp.services;

import com.yusuferdogan.todoapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public void addUser(User user);

    public void removeUser(Long id);

    List<User> getAllUsers();

    boolean isUserExist(Long id);

    public boolean isUserExist(String email);

    User getUserByEmailAndPassword(String email,String password);

    Optional<User> findById(Long id);


    }
