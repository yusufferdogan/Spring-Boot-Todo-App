package com.yusuferdogan.todoapp.services;
import com.yusuferdogan.todoapp.domain.User;
import com.yusuferdogan.todoapp.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository ;

    User user = new User();

    @Autowired
    private UserService userService;

    @BeforeAll
    void setUp() {
        user.setEmail("asdfg@gmail.com");
        user.setPassword("123456");
        userService.addUser(user);
    }

    @AfterAll
    void dispose(){
        userService.removeUser(user.getId());
    }

    @Test
    void testFindAll() {
        Assertions.assertFalse(userService.getAllUsers().isEmpty());
    }

    @Test
    void testIsUserExist() {
        Assertions.assertNotNull(userService.findById(user.getId()));
    }

    @Test
    void testIsUserExistById() {
        Assertions.assertTrue(userService.isUserExist(user.getId()));
    }

    @Test
    void testRemoveUser() {
        User testingUser = user;
        userService.addUser(testingUser);
        userService.removeUser(testingUser.getId());
        Assertions.assertFalse(userService.isUserExist(testingUser.getId()));
    }
}
