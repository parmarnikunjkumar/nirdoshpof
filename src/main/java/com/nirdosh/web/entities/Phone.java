package com.nirdosh.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String number;
	
	@Column(name="phone_type")
	private Integer phoneType ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@BatchSize(size=100)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Transient
	public String preetyPrint() {
		return preetyPrint(0);
	}
	
	@Transient
	public String preetyPrint(int indentLevel) {
		StringBuffer output = new StringBuffer();
		output.append(StringUtils.repeat("\t", indentLevel)).append("Phone ").append(toString()).append("\n");
		return output.toString();
	}
	
	@Override
	@Transient
	public String toString() {
		StringBuffer output = new StringBuffer("[");
		output.append("id =").append(id);
		output.append(", number=").append(number);
		output.append(", type =").append(phoneType);
		output.append(", customer=").append(customer);
		output.append("]");
		
		return output.toString();
		
	}

}
