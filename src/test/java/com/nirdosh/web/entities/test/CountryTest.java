package com.nirdosh.web.entities.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.Country;
import com.nirdosh.web.entities.State;
import com.nirdosh.web.test.AbstractTest;

public class CountryTest extends AbstractTest{
	
	private final Logger logger = LoggerFactory.getLogger(CountryTest.class);

	@Autowired
	private GeneralDAO generalDAO;
	
//	@Test
	@Transactional
	@Rollback(true)
	public void createCounty() {
	
			Country country = new Country();
			country.setName("Germany");
			country.setCountryCode("DE");
			
			generalDAO.save(country);		
	}
	
	@Test
	@Transactional
	public void getStates() {
		Country country = generalDAO.find(Country.class, 2);
		
		Set<State> states = country.getStates();
		
		for(State state: states) {
			logger.debug("FOUND:{}",state.preetyPrint());
		}
	}
}
