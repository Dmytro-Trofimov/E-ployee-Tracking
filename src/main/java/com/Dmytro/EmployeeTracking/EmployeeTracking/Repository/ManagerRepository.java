package com.Dmytro.EmployeeTracking.EmployeeTracking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{

	Manager findByUsername(String managerName);

}
