package com.nirdosh.web.entities.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.nirdosh.web.entities.Address;
import com.nirdosh.web.entities.City;
import com.nirdosh.web.entities.Country;
import com.nirdosh.web.entities.Customer;
import com.nirdosh.web.entities.State;
import com.nirdosh.web.entities.enums.AddressTypeEnum;
import com.nirdosh.web.test.AbstractTest;

public class AddressTest extends AbstractTest{
	
	@Autowired
	private GeneralDAO generalDAO;
	@Test
	@Transactional
	@Rollback(true)
	public void createAddress(){
		
		City city = generalDAO.find(City.class, 1);
		State state = generalDAO.find(State.class, 2);
		Country country = generalDAO.find(Country.class, 2);
		Customer customer = generalDAO.find(Customer.class, 1);
		
		Address address = new Address();
		
		address.setAddressType(AddressTypeEnum.HOME.getAddressType());
		address.setCity(city);
		address.setCountry(country);
		address.setState(state);
		address.setHouseNumber("10");
		address.setStreetName("Im Tal");
		address.setPLZ("14532");
		address.setCustomer(customer);
		
		
		generalDAO.save(address);
		
		
	}

}
