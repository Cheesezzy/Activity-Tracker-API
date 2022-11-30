package com.example.spring.demo.service;

import com.example.spring.demo.entity.Task;
import com.example.spring.demo.enums.Status;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.TaskDto;
import com.example.spring.demo.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ResponseManager responseManager;

    public TaskDto addTask(TaskDto task){

        Task newTask = new Task();
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setStatus(task.getStatus());

       newTask = taskRepo.save(newTask);
       task.setTaskId(newTask.getTaskId());
       task.setTitle(newTask.getTitle());
       task.setDescription(newTask.getDescription());
       task.setStatus(newTask.getStatus());
        return task;
    }

    public ApiResponse viewAllTask(){
        List<Task> task = new ArrayList<>();
        if (!task.isEmpty())
            return responseManager.error("No task available");
        else
        taskRepo.findAll().forEach(task::add);
        return responseManager.success(task);
    }
    public ApiResponse updateTask(Long taskId, TaskDto taskDto){
        Optional<Task> taskOptional = taskRepo.findById(taskId);
        Task taskUpdate = taskOptional.orElseThrow(() ->
                new NoSuchElementException("Task with id: " + taskId + " not found."));
        String title = taskDto.getTitle();
        String description = taskDto.getDescription();
        Status status = taskDto.getStatus();
        if(title != null && !title.isBlank()) {
            taskUpdate.setTitle(taskDto.getTitle());
        }
        if (description != null && !description.isBlank()){
            taskUpdate.setDescription(taskDto.getDescription());
        }
        if (status != null){
            taskUpdate.setStatus(taskDto.getStatus());
        }
        return responseManager.success(taskRepo.save(taskUpdate));
    }
    public ApiResponse deleteTask(Long taskId){
        taskRepo.deleteById(taskId);
        return responseManager.success(taskId);
    }

    public ApiResponse viewById(Long id){
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null)
            return responseManager.success(task);
        return responseManager.error("User not found");
    }

    public ApiResponse viewTaskByStatus(Status status){
        List<Task> task = new ArrayList<>();
        if (!task.isEmpty())
            return responseManager.error("No task available");
        else
            taskRepo.viewByStatus(status.toString()).forEach(task::add);
        return responseManager.success(task);
    }
}
