package com.example.resume_platform.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiUtil<T> {
    private boolean success;
    private T data;

    public ApiUtil(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

}