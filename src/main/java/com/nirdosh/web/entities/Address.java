package com.nirdosh.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.BatchSize;
import org.junit.ClassRule;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
		
	@Column(name="street")
	private String streetName;
	
	@Column(name="house_number")
	private String houseNumber;
	
	private String PLZ;
	
	@Column(name="address_type")
	private Integer addressType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@BatchSize(size=100)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id")
	private State state;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPLZ() {
		return PLZ;
	}

	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}	

	public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
