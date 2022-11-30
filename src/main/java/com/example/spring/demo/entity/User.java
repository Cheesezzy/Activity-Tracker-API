package com.example.spring.demo.entity;

import com.example.spring.demo.pojos.UserLoginDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends UserLoginDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =50)
    private String name;

    @Column(nullable = false, length = 50)
    private String uuid;

    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void setCreatedAt(){
        createdAt = new Date();
    }
    @PreUpdate
    public void setUpdatedAt(){
        updatedAt= new Date();
    }

}
