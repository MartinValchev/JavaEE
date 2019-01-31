package com.java.sample_project.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "FullTimeEmployee.findAll", query = "select e from FullTimeEmployee e") })
@Table(name = "CH04_MS_FULL_TIME_EMPLOYEE")
public class FullTimeEmployee extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7372102529288173996L;
	@Column(name="ANNUAL_SALARY")
	private double annualSalary;
	@OneToMany(mappedBy="manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Employee> managedEmployees;
	public FullTimeEmployee() {}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	public List<Employee> getManagedEmployees() {
		return managedEmployees;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public void setManagedEmployees(List<Employee> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
	public Employee addEmployee(Employee employee) {
		getManagedEmployees().add(employee);
		employee.setManager(this);
		return employee;
	}
	public Employee removeEmployee(Employee employee){
		getManagedEmployees().remove(employee);
		employee.setManager(null);
		return employee;
	}
}
