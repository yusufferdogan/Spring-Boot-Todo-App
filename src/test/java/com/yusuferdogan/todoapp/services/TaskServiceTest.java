package com.yusuferdogan.todoapp.services;
import com.yusuferdogan.todoapp.domain.Task;
import com.yusuferdogan.todoapp.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TaskServiceTest {

    Task task = new Task();
    User user = new User();

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @BeforeAll
    void setUp(){
        user.setEmail("asdfg@gmail.com");
        user.setPassword("123456");
        userService.addUser(user);
//----------------------------------------------- init user
        task.setTaskName("TESTING TASK NAME ");
        task.setTaskDescription("TESTING TASK DESCRIPTION");
        task.setIsDone(false);
        task.setUser(user);
        taskService.addTask(task);
// ---------------------------------------------- init task
    }

    @AfterAll
    void dispose(){
        taskService.removeTask(task.getId());
        userService.removeUser(user.getId());
        for(Task t: taskService.getAllTasks()){
            System.out.println(t);
        }
    }

    @Test
    void testGetAllTasks(){
        Assertions.assertFalse(taskService.getAllTasks().isEmpty());
    }

    @Test
    void testGetAllTasksOfUser(){
        Assertions.assertFalse(taskService.getAllTasksOfUser(user.getemail(),user.getPassword()).isEmpty());
    }

    @Test
    void testGetTaskById(){
        Assertions.assertNotNull(taskService.getTaskById(task.getId()));
    }

    @Test
    void testUpdateTask(){
        final String updated_task_name = "TEST_UPDATE_TASK_NAME";
        task.setTaskName(updated_task_name);
        Assertions.assertEquals(updated_task_name,task.getTaskName());
    }

    @Test
    void testRemoveTask() {
        Task testingTask = task;
        taskService.addTask(testingTask);
        assert testingTask != null;
        taskService.removeTask(testingTask.getId());
        Assertions.assertNotNull(taskService.getTaskById(testingTask.getId()));
    }



}
