package com.Dmytro.EmployeeTracking.EmployeeTracking.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dmytro.EmployeeTracking.EmployeeTracking.Repository.EmployeeRepository;
import com.Dmytro.EmployeeTracking.EmployeeTracking.entity.Employee;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tracking")
public class MController {
		
	@Autowired
	EmployeeRepository repo;
	
	@RequestMapping({"/", ""})
	public String showAllEmployees(Model model) {
		List<Employee> employees = repo.findAll();
		model.addAttribute("employees", employees);
		return "ShowAllEmployees";
	}
	@RequestMapping("/addNewEmployee")
	public String createNewEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		return "addNewEmployee";
	}
	@PostMapping("/AddEmployeeIntoDB")
	public String AddEmployeeIntoDB(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
		if(br.hasErrors()) {
			return "addNewEmployee";
		}
		repo.save(employee);
		return "redirect:";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam int id) {
		repo.deleteById(id);
		return "redirect:";
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam int id, Model model) {
		Employee emp = repo.findById(id).get();
		model.addAttribute("employee", emp);
		return "editEmployee";
	}
	@PostMapping("/editEmployee")
	public String editEmployee(@ModelAttribute("employee") Employee employee, BindingResult br, @RequestParam int id) {
		if(br.hasErrors()) {
			return "addNewEmployee";
		}
		Employee emp = repo.findById(id).get();
		emp.setAddress(employee.getAddress());
		emp.setDepartment(employee.getDepartment());
		emp.setEmail(employee.getEmail());
		emp.setName(employee.getName());
		emp.setPhone(employee.getPhone());
		emp.setSalary(employee.getSalary());
		repo.save(emp);
		return "redirect:";
	}
}
