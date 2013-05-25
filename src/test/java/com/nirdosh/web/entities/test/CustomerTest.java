package com.nirdosh.web.entities.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.Customer;
import com.nirdosh.web.entities.Phone;
import com.nirdosh.web.test.AbstractTest;

@Transactional
public class CustomerTest extends AbstractTest {


	private final Logger logger = LoggerFactory.getLogger(CustomerTest.class);
	
	@Autowired
	private GeneralDAO generalDAO;
	
//	@Test
	@Transactional
	@Rollback(true)
	public void createCustomer() {
		
		Customer customer = new Customer();
		customer.setName("Nikunjkumar");
		customer.setSurname("Parmar");
		
		generalDAO.save(customer);
	}
	
	@Test
	public void getPhones() {
		Customer customer = generalDAO.find(Customer.class, 1);
		List<Phone> phones = customer.getPhones();
		
		for(Phone phone: phones) {
			logger.debug("Found:{}",phone.preetyPrint());
		}
	}
	
}
