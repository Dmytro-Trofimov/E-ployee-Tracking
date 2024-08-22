package com.Dmytro.EmployeeTracking.EmployeeTracking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="manager")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public Manager(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
