package com.nirdosh.web.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,orphanRemoval=true,mappedBy="state")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@BatchSize(size=100)
	private Set<City> cities;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
		output.append(StringUtils.repeat("\t", indentLevel)).append("State ").append(toString()).append("\n");
		return output.toString();
	}
	
	@Override
	@Transient
	public String toString() {
		StringBuffer output = new StringBuffer("[");
		output.append("id =").append(id);
		output.append(", name=").append(name);
		output.append(", country=").append(country);
		output.append("]");
		
		return output.toString();
		
	}
	
	
}
