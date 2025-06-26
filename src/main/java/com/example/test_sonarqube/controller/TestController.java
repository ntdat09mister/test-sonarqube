package com.example.test_sonarqube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // This is a test controller for SonarQube analysis
    // It contains a method that returns a simple greeting message
    @GetMapping("/greet")
    public String greet() {
        return "Hello, SonarQube!";
    }
}
