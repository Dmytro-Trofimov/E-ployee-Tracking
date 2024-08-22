package com.Dmytro.EmployeeTracking.EmployeeTracking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
