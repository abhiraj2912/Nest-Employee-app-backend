package com.nest.nestemployeeappbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee", consumes = "application/json", produces = "application/json")
    public String addEmployee(){
        return "employee add";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addtask", consumes = "application/json", produces = "application/json")
    public String addTask(){
        return "add task";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public String login(){
        return "Login";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empviewtask", consumes = "application/json", produces = "application/json")
    public String employeeViewTask(){
        return "employeeViewTask";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminviewtask")
    public String adminViewTask(){
        return "employeeViewTask";
    }
}
