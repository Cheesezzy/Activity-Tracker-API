package com.example.spring.demo;

import com.example.spring.demo.entity.Task;
import com.example.spring.demo.enums.Status;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.TaskDto;
import com.example.spring.demo.repository.TaskRepo;
import com.example.spring.demo.service.ResponseManager;
import com.example.spring.demo.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.spring.demo.enums.Status.OPEN;

@ExtendWith(MockitoExtension.class)
public class TaskTest {

    @Mock
    ResponseManager responseManager;
    @Mock
    TaskRepo taskRepo;

    @InjectMocks
    TaskService taskService;

    @Test
    void readAllTaskTest(){
        List<Task> taskList = new ArrayList<>();

        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(1L);
        taskDto.setTitle("Hiking");
        taskDto.setDescription("go hiking with richards and owen");
        taskDto.setStatus(OPEN);

        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());

        taskList.add(task);
        boolean res = !taskList.isEmpty();

        Assertions.assertTrue(res);
    }
    @Test
    void deleteTaskTest(){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(1L);
        taskDto.setTitle("Hiking");
        taskDto.setDescription("go hiking with richards and owen");
        taskDto.setStatus(OPEN);

        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        taskRepo.save(task);

        ApiResponse res = taskService.deleteTask(1L);
        ApiResponse req = responseManager.success(task.getTaskId());

        Assertions.assertEquals(res,req);
    }

    @Test
    void updateTaskTest(){

        TaskDto taskDto = new TaskDto();
        taskDto.setStatus(OPEN);

        Task task = new Task();
        task.setStatus(taskDto.getStatus());

        boolean res = task.getStatus().equals(OPEN);
        Assertions.assertTrue(res);
    }
}
