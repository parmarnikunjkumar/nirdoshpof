package com.nirdosh.web.dao;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.Customer;


public interface CustomerDAO extends GeneralDAO{
	
	public Customer findCustomer(Integer id);
	
	public List<Customer> findCustomers(String name, String surname);

}
