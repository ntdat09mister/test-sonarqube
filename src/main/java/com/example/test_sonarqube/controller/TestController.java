package com.example.test_sonarqube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/greet")
    public String greet() {
        return "Hello, SonarQube!";
    }
}
