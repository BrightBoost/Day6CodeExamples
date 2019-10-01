package com.example.demo.service;

import com.example.demo.annotation.LoggerAnnotation;

public class CustomService {
    @LoggerAnnotation
    public void serviceMethod() throws InterruptedException {
        Thread.sleep(3000);
    }
}
