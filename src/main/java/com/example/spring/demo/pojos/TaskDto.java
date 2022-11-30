package com.example.spring.demo.pojos;

import com.example.spring.demo.enums.Status;
import lombok.Data;

@Data
public class TaskDto {
    private Long taskId;
    private String title;
    private String description;
    private Status status;

}
