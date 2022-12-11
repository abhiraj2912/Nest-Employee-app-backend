package com.nest.nestemployeeappbackend.dao;

import com.nest.nestemployeeappbackend.model.Employee;
import com.nest.nestemployeeappbackend.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task, Integer> {

    @Query(value = "SELECT `id`, `description`, `status`, `task_name`, `empid` FROM `tasks` WHERE `empid`= :empid",nativeQuery = true)
    List<Task> employeeViewTask(@Param("empid") Integer empid);

    @Query(value = "SELECT `id`, `description`, `status`, `task_name`, `empid` FROM `tasks` WHERE `empid`= :empid AND task_name like %:taskName%",nativeQuery = true)
    List<Task> employeeSearchTask(@Param("empid") Integer empid, @Param("taskName") String taskName);

    @Query(value = "SELECT  e.`id`, e.`designation`, e.`email`, e.`name`, e.`phone`, t.task_name, t.description, t.status FROM `employees` e JOIN tasks t ON e.id=t.empid", nativeQuery = true)
    List<Map<String,String>> adminVIewTask();

    @Query(value = "SELECT e.`id`, e.`designation`, e.`email`, e.`name`, e.`phone`, t.task_name, t.description, t.status FROM `employees` e JOIN tasks t ON e.id=t.empid WHERE e.name LIKE %:name%", nativeQuery = true)
    List<Map<String,String>> adminSearchTask(@Param("name") String name);



    @Transactional
    @Modifying
    @Query(value = "UPDATE `tasks` SET `status`=:status WHERE `id`=:id",nativeQuery = true)
    void updateStatus(@Param("id") Integer id, @Param("status") String status);
}
