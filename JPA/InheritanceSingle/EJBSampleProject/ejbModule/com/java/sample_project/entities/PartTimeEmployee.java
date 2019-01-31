package com.java.sample_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({@NamedQuery(name="PartTimeEmployee.findAll", query="select e from PartTimeEmployee e")})
@Table(name="PART_TIME_EMPLOYEE")
public class PartTimeEmployee extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1108897904475547993L;
	@Column(name="HOURLY_WAGE")
	private double hourlyWage;
	 public PartTimeEmployee() {}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	 
	 
	
}
