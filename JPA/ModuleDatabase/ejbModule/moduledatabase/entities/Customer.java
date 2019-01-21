package moduledatabase.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity(name = "Customer")
@Table(name = "CUSTOMER")
@TableGenerator(name = "Customer_ID_Generator", table = "customer_id_gen", pkColumnName = "PRIMARY_KEY_NAME", pkColumnValue = "Customer.id", valueColumnName = "NEXT_ID_VALUE")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5260484685199530491L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Customer_ID_Generator")
	private BigDecimal id;

	@Version
	private int version;
	
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL })
	private List<CustomerOrder> customerOrders;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "BILLING_ADDRESS_ID")
	private Address billingAddress;

	@OneToOne
	@JoinColumn(name = "SHIPPING_ADDRESS_ID")
	private Address shippingAddress;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", customerOrders=" + customerOrders + ", billingAddress="
				+ billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}
	
	

}
