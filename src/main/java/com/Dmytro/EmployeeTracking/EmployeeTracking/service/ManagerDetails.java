package com.Dmytro.EmployeeTracking.EmployeeTracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Dmytro.EmployeeTracking.EmployeeTracking.Repository.ManagerRepository;
import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.Manager;
import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.ManagerPrincipal;

@Service
public class ManagerDetails implements UserDetailsService{

	@Autowired
	private ManagerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager user1 = repo.findByUsername(username);
		
		if(user1 == null) {
			System.out.println("no such user");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new ManagerPrincipal(user1);
	}

}
