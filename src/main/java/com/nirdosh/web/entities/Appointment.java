package com.nirdosh.web.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	private Integer id;
	
	private Date when;
	
	@OneToOne
	private Worker withWhom;
	
	@OneToOne
	private Customer who;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public Worker getWithWhom() {
		return withWhom;
	}

	public void setWithWhom(Worker withWhom) {
		this.withWhom = withWhom;
	}

	public Customer getWho() {
		return who;
	}

	public void setWho(Customer who) {
		this.who = who;
	}
}
