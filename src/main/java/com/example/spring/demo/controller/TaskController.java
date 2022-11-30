package com.example.spring.demo.controller;

import com.example.spring.demo.entity.Task;
import com.example.spring.demo.enums.Status;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.TaskDto;
import com.example.spring.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @PostMapping("/add-task")
    public ApiResponse addTask(@RequestBody TaskDto task){
        task = taskService.addTask(task);
        return new ApiResponse<>("Task added",true,task);
    }

    @GetMapping("/view-all-task")
    public ApiResponse viewAllTask(){
        return taskService.viewAllTask();
    }

    @PutMapping("/update-task/{taskId}")
    public ApiResponse updateTask(@PathVariable Long taskId, @RequestBody TaskDto task){
       return taskService.updateTask(taskId,task);
    }
    @DeleteMapping("/delete-task/{taskId}")
    public ApiResponse deleteTask(@PathVariable Long taskId){
         return taskService.deleteTask(taskId);
    }

    @GetMapping("/view-task/{taskId}")
    public ApiResponse viewTaskById(@PathVariable Long taskId){
        return taskService.viewById(taskId);
    }

    @GetMapping("/view/{status}")
    public ApiResponse viewByStatus(@PathVariable Status status){
        return taskService.viewTaskByStatus(status);
    }
}
