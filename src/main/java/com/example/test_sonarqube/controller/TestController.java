package com.example.test_sonarqube.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

@RestController
public class TestController {

    // 🛑 1. Hardcoded credentials - critical security issue
    private static final String PASSWORD = "admin123";

    // 🛑 2. Null pointer dereference risk
    private String riskyNull;

    // 🛑 3. Unused local variable
    private void unusedMethod() {
        int unused = 42;
    }

    // 🛑 4. Empty catch block - ignores potential exceptions
    @GetMapping("/readFile")
    public String readFile() {
        try {
            File file = new File("/tmp/somefile.txt");
            FileInputStream fis = new FileInputStream(file);
        } catch (Exception e) {
            // silently ignored
        }
        return "Done reading file (maybe)";
    }

    // 🛑 5. Return duplicated string (code smell) and possible null usage
    @GetMapping("/greet")
    public String greet() {
        if (riskyNull.equals("test")) { // possible NullPointerException
            return "Hello again";
        }
        return "Hello, SonarQube!";
    }
}
