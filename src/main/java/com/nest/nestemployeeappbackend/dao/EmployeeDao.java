package com.nest.nestemployeeappbackend.dao;

import com.nest.nestemployeeappbackend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `name`, `password`, `phone`, `salary`, `username` FROM `employees` WHERE `username`=:username AND `password` =:password", nativeQuery = true)
    List<Employee> login(@Param("username") String username, @Param("passwprd") String password);
}
