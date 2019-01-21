package moduledatabase.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 3758379456661378447L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	
	private int zipCode;
	
	private String city;
	
	
	public BigDecimal getId() {
		return id;
	}
	
	public void setId(BigDecimal addressId) {
		this.id = addressId;
	}

	public int getZipCode() {
			return this.zipCode;
	}
	public void setZipCode(int zipCode) {
		if(zipCode != this.zipCode) {
			city = null;
			this.zipCode = zipCode;
		}
	}

	public String getCity() {
		// Derive the city from the zipcode property, if available
		if (city == null && zipCode > 0) {
		city = deriveCityFromZip();
		}
		return city;
		}
		public void setCity(String city) {
		this.city = city;
		}
		private String deriveCityFromZip() {
		/* Implementation here. . . */
		return null;
		}
		
		@Override
		public String toString() {
			return "Address [addressId=" + id + ", zipCode=" + zipCode + ", city=" + city + "]";
		}

}
