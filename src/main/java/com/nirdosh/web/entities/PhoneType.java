package com.nirdosh.web.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneType {
	@Id
	private Integer id;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
