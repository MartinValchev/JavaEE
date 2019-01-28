package moduledatabase.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CustomerOrder.findAll", query = "select e from CustomerOrder e") })
@Table(name = "customer_order")
@TableGenerator(name = "CustomerOrder_ID_Generator", table = "customer_order_id_generator", pkColumnName = "PRIMARY_KEY_NAME", pkColumnValue = "CustomerOrder.id", valueColumnName = "NEXT_ID_VALUE")
public class CustomerOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7924109517084151791L;
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CustomerOrder_ID_Generator")
	private BigDecimal id;

	@Version
	private int version;

	@Column(name = "CREATION_DATE")
	private Date creationDate;
	private String status;
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", creationDate=" + creationDate + ", status=" + status + ", customer="
				+ customer + "]";
	}

}
