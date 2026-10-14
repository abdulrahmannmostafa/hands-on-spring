package com.qeema.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qeema.demo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();

}