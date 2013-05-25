package com.nirdosh.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.googlecode.genericdao.dao.hibernate.GeneralDAOImpl;
import com.nirdosh.web.dao.CustomerDAO;
import com.nirdosh.web.entities.Customer;

public class CustomerDAOImpl extends GeneralDAOImpl implements CustomerDAO {
	
	@Autowired
	private GeneralDAO generalDAO;


	public Customer findCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findCustomers(String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
