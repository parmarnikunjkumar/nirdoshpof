package com.nirdosh.web.entities.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.City;
import com.nirdosh.web.entities.Country;
import com.nirdosh.web.entities.State;
import com.nirdosh.web.test.AbstractTest;

public class CityTest extends AbstractTest{
	
	private final Logger logger = LoggerFactory.getLogger(CityTest.class);
	
	@Autowired
	private GeneralDAO generalDAO;

//	@Test
	@Rollback(false)
	@Transactional
	public void createCity() {
		
		Country country = generalDAO.find(Country.class, 2);
		
		State state = generalDAO.find(State.class, 2);
		
		City city = new City();
		city.setCountry(country);
		city.setState(state);
		city.setName("Bernau");
		
		generalDAO.save(city);
	}
	
	@Test
	@Transactional
	public void getCites() {
		
		List<City> cities = generalDAO.findAll(City.class);
		
		for(City city: cities) {
			logger.debug("Found: {}",city.preetyPrint());
		}
	}

}
