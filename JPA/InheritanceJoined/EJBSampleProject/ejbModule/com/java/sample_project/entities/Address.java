package com.java.sample_project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({@NamedQuery(name="Address.findAll", query="select o from Address o")})
@Table(name="CH04_JOIN_ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1108125733405229088L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(length=400)
	private String city;
	@Column(length=2)
	private String state;
	@Column(length = 400)
	private String street1;
	@Column(length = 400)
	private String street2;
	
	@Column(name="ZIP_CODE")
	private String zipCode;
	@Version
	private Integer version;
	public String getCity() {
		return city;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}
