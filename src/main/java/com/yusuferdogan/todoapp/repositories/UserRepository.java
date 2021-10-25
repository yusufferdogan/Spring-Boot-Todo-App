package com.yusuferdogan.todoapp.repositories;

import com.yusuferdogan.todoapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User getByEmailAndPassword(String email, String password);
}
