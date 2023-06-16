package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	Integer id;
	String Name;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(Integer id, String name) {
		super();
		this.id = id;
		Name = name;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", id=" + id + "]";
	}
	
	
}
