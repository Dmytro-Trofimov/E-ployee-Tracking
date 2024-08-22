package com.Dmytro.EmployeeTracking.EmployeeTracking.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dmytro.EmployeeTracking.EmployeeTracking.Repository.ManagerRepository;
import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.Manager;

import jakarta.validation.Valid;

@Controller
public class ManagerOperation {
	
	@Autowired
	ManagerRepository repo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@RequestMapping("/addManager")
	public String AddManager(Model model) {
		model.addAttribute("manager", new Manager());
		return "addManager";
	}
	@PostMapping("/put")
	public String AddManagerIntoDB(@Valid @ModelAttribute("prdto") Manager manager, BindingResult br) {
		System.out.println(manager);
		System.out.println(br);
		if(br.hasErrors()) {
			return "addManager";
		}
		System.out.println(manager.getPassword());
		System.out.println(encoder.encode(manager.getPassword()));
		manager.setPassword(encoder.encode(manager.getPassword()));
		repo.save(manager);
		return "redirect:tracking";
	}
}
