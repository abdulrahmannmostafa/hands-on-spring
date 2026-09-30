package com.qeema.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qeema.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
