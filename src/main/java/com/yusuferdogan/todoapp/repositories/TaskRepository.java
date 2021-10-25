package com.yusuferdogan.todoapp.repositories;

import com.yusuferdogan.todoapp.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface TaskRepository extends CrudRepository<Task,Long> {
}
