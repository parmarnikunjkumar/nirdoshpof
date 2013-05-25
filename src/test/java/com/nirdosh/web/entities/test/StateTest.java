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
import com.nirdosh.web.entities.City;
import com.nirdosh.web.entities.Country;
import com.nirdosh.web.entities.State;
import com.nirdosh.web.test.AbstractTest;

public class StateTest extends AbstractTest{
	
	private final Logger logger = LoggerFactory.getLogger(StateTest.class);
	
	@Autowired
	private GeneralDAO generalDAO;
	
//	@Test
	@Rollback(true)
	@Transactional
	public void createState() {
		Country country = generalDAO.find(Country.class, 2);
		
		State state = new State();
		state.setName("Brandenburg");
		state.setCountry(country);
		
		generalDAO.save(state);
	}
	
//	@Test
	@Transactional
	public void getStates() {
		List<State> states = generalDAO.findAll(State.class);
		
		for(State state: states) {
			logger.debug("Found : {}",state.preetyPrint());
		}
	}

	@Test
	@Transactional
	public void getCities() {
		State state = generalDAO.find(State.class, 2);
		Set<City> cities = state.getCities();
		for(City city: cities) {
			logger.debug("Found:{}", city.preetyPrint());
		}
	}
}
