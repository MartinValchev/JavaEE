package com.java.sample_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="Employee.findAll", query="select o from Employee o")})
@Table(name="CH04_TPC_Employee")
public class Employee extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8801770978423185319L;
	@Column(length=400)
	private String department;
	@Column(length=400)
	private String email;
	@ManyToOne
	@JoinColumn(name="MANAGER")
	private FullTimeEmployee manager;
	
	public Employee() {}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}

	public FullTimeEmployee getManager() {
		return manager;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setManager(FullTimeEmployee manager) {
		this.manager = manager;
	}
	
}
