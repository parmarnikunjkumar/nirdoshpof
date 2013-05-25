package com.nirdosh.web.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cascade;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id")
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	private State state;
	
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}		
	
	@Transient
	public String preetyPrint() {
		return preetyPrint(0);
	}
	
	@Transient
	public String preetyPrint(int indentLevel) {
		StringBuffer output = new StringBuffer();
		output.append(StringUtils.repeat("\t", indentLevel)).append("City ").append(toString()).append("\n");
		return output.toString();
	}
	
	@Override
	@Transient
	public String toString() {
		StringBuffer output = new StringBuffer("[");
		output.append("id =").append(id);
		output.append(", name=").append(name);
		output.append(", state=").append(state);
		output.append(", country=").append(country);
		output.append("]");
		
		return output.toString();
		
	}
}
