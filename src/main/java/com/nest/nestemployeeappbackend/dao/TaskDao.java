package com.nest.nestemployeeappbackend.dao;

import com.nest.nestemployeeappbackend.model.Employee;
import com.nest.nestemployeeappbackend.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task, Integer> {

    @Query(value = "SELECT `id`, `description`, `status`, `task_name`, `empid` FROM `tasks` WHERE `empid`= :id",nativeQuery = true)
    List<Task> employeeViewTask(@Param("id") Integer id);

    @Query(value = "SELECT  `designation`, `email`, `name`, `phone` FROM `employees` e JOIN tasks t ON e.id=t.empid", nativeQuery = true)
    List<Map<String,String>> adminVIewTask();

    @Query(value = "SELECT  `designation`, `email`, `name`, `phone` FROM `employees` e JOIN tasks t ON e.id=t.empid e.name LIKE %:%", nativeQuery = true)
    List<Map<String,String>> adminSearchTask(@Param("name") String name);
}
