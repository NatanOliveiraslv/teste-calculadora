package org.example.userManager;

import org.example.taskmanager.Task;
import org.example.taskmanager.TaskService;

import java.util.List;

public class UserManager {

    private final UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public User getAllTasks() {
        User user = userService.createUser();
        return user;
    }

}
