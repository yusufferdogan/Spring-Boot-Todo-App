package com.yusuferdogan.todoapp.services;

import com.yusuferdogan.todoapp.domain.User;
import com.yusuferdogan.todoapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.delete(user.get());
        }

    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean isUserExist(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.isPresent();
    }

    @Override
    public boolean isUserExist(String email) {
        Iterable<User> users = userRepository.findAll();

        for(User u:users){
            if(email.equals(u.getemail())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.getByEmailAndPassword(email,password);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


}
