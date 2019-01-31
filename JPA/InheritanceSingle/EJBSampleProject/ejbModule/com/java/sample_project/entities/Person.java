package com.java.sample_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "select e from Person e") })
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5295065005516238649L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="FIRST_NAME", length=400)
	private String firstName;
	@Column(name="LAST_NAME", length=400)
	private String lastName;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address homeAddress;
	@Version
	private Integer version;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public Integer getVersion() {
		return version;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
