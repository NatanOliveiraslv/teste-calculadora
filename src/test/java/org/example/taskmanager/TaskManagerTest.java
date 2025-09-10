package org.example.taskmanager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaskManagerTest {

    @Test
    public void shouldGetAllTasks(){
        // Arrange

        TaskService mockTaskService = mock(TaskService.class);

        List<Task> sampleTaskes = new ArrayList<Task>();

        sampleTaskes.add(new Task(1,"Task 1", "Description 1"));
        sampleTaskes.add(new Task(2,"Task 2", "Description 2"));

        when(mockTaskService.getAllTasks()).thenReturn(sampleTaskes);

        TaskManager taskManager = new TaskManager(mockTaskService);

        // Action

        List<Task> tasks = taskManager.getAllTasks();

        // Assert
        verify(mockTaskService).getAllTasks();
        assertEquals(sampleTaskes, tasks);
    }

}
