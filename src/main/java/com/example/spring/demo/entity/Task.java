package com.example.spring.demo.entity;

import com.example.spring.demo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Table(name = "userTask")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id", nullable = false)
    private Long taskId;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Date createdAt;
    private Date updatedAt;


    private Date completedAt;

    @PrePersist
    public void setCreatedAt(){
        createdAt = new Date();
    }
    @PreUpdate
    public void setUpdatedAt(){
        updatedAt= new Date();
        if (status.equals(Status.CLOSED)){
            completedAt = new Date();
        }
    }


}
