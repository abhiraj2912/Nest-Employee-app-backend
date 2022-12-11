package com.nest.nestemployeeappbackend.controller;

import com.nest.nestemployeeappbackend.dao.EmployeeDao;
import com.nest.nestemployeeappbackend.dao.TaskDao;
import com.nest.nestemployeeappbackend.model.Employee;
import com.nest.nestemployeeappbackend.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao edao;

    @Autowired
    private TaskDao tdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> addEmployee(@RequestBody Employee e){
        edao.save(e);
        HashMap <String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addtask", consumes = "application/json", produces = "application/json")
    public  HashMap<String,String> addTask(@RequestBody Task t){
        tdao.save(t);
        HashMap <String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e){
        HashMap <String,String> map = new HashMap<>();
        List <Employee> result = edao.login(e.getUsername(),e.getPassword());
        if (result.size()!=0){
            map.put("status","success");
            int id = result.get(0).getId();
            map.put("id",String.valueOf(id));
        }
        else {
            map.put("status","failed");
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empviewtask", consumes = "application/json", produces = "application/json")
    public List<Task> employeeViewTask(@RequestBody Task t){
        String id = String.valueOf(t.getEmpid());
        System.out.println(id);
        return (List<Task>) tdao.employeeViewTask(t.getEmpid());
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/adminviewtask")
    public List<Map<String,String>> adminViewTask(){
        return tdao.adminVIewTask();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminsearchtask", consumes = "application/json", produces = "application/json")
    public List<Map<String,String>> adminSearchTask(@RequestBody Employee e){
        return tdao.adminSearchTask(e.getName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeesearchtask", consumes = "application/json", produces = "application/json")
    public List<Task> employeeSearchTask(@RequestBody Task t){
        return tdao.employeeSearchTask(t.getEmpid(),t.getTaskName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adminsearchemp", consumes = "application/json", produces = "application/json")
    public List<Employee> adminSearchEmployee(@RequestBody Employee e){
        return edao.search(e.getName());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatestatus", consumes = "application/json", produces = "application/json")
    public  HashMap<String,String> updateStatus(@RequestBody Task t){
        tdao.updateStatus(t.getId(),t.getStatus());
        HashMap <String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }
}
