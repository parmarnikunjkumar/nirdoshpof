package com.nirdosh.web.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

@Entity
public class Country {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@Column(name="country_code")
	private String countryCode;
	
	@OneToMany(fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="country")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@BatchSize(size=100)
	private Set<State> states;

	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="country")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@BatchSize(size=100)
	private Set<City> cities;
	
	
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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	@Transient
	public String preetyPrint() {
		return preetyPrint(0);
	}
	
	@Transient
	public String preetyPrint(int indentLevel) {
		StringBuffer output = new StringBuffer();
		output.append(StringUtils.repeat("\t", indentLevel)).append("Country ").append(toString()).append("\n");
		return output.toString();
	}
	
	@Override
	@Transient
	public String toString() {
		StringBuffer output = new StringBuffer("[");
		output.append("id =").append(id);
		output.append(", name=").append(name);
		output.append(" ,countryCode=").append(countryCode);
		output.append("]");
		
		return output.toString();
		
	}
	
	
}
