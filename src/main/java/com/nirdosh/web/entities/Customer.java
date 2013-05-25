package com.nirdosh.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	private String name;
	
	private String surname;
	
	@OneToMany(fetch=FetchType.LAZY)
	@BatchSize(size=100)
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private List<Address> addresses = new ArrayList<Address>();
	
	@OneToMany(fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="customer")
	@BatchSize(size=100)
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private List<Phone> phones = new ArrayList<Phone>();
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="customer")
	@BatchSize(size=100)
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private List<Email> emails = new ArrayList<Email>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}		

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	@Transient
	public String preetyPrint() {
		return preetyPrint(0);
	}
	
	@Transient
	public String preetyPrint(int indentLevel) {
		StringBuffer output = new StringBuffer();
		output.append(StringUtils.repeat("\t", indentLevel)).append("Person ").append(toString()).append("\n");
		return output.toString();
	}
	
	@Override
	@Transient
	public String toString() {
		StringBuffer output = new StringBuffer("[");
		output.append("id =").append(id);
		output.append(", name=").append(name);
		output.append(", surname =").append(surname);
		output.append("]");
		
		return output.toString();
		
	}
	
}
