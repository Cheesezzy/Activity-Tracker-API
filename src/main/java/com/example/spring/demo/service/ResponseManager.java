package com.example.spring.demo.service;

import com.example.spring.demo.pojos.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResponseManager<T> {
    public ApiResponse<T> success(T data){
        return new ApiResponse<T>("Request successful",true,data);
    }
    public ApiResponse<T> error(String errorMessage){
        return new ApiResponse<T>(errorMessage,false, null);
    }

}
