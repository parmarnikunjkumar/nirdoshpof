package com.nirdosh.web.entities.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.Customer;
import com.nirdosh.web.test.AbstractTest;


public class PersonTest extends AbstractTest {
	
	private final Logger logger = LoggerFactory.getLogger(PersonTest.class);
	
	@Autowired
	private GeneralDAO generalDAO;
	
	@Test
	@Transactional
	public void testPersonFetching() {
		
		try {
		Customer person = generalDAO.find(Customer.class,1);
		
		logger.debug("we found {}", person.preetyPrint());	
		}catch(Exception exp) {
			logger.debug("Exception : {}",exp.getMessage());
		}
	}

}
