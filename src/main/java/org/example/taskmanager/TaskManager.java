package org.example.taskmanager;

import java.util.List;

public class TaskManager {

    private final TaskService taskService;

    public TaskManager(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return tasks;
    }

}
