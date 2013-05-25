package com.nirdosh.web.entities.test;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.nirdosh.web.entities.Customer;
import com.nirdosh.web.entities.Phone;
import com.nirdosh.web.entities.enums.PhoneTypeEnum;
import com.nirdosh.web.test.AbstractTest;

public class PhoneTest extends AbstractTest {
	

	@Test
	@Transactional
	@Rollback(false)
	public void createPhones() {
		
		Customer customer = generalDAO.find(Customer.class, 1);
		
		Phone phone1 = new Phone();
		phone1.setCustomer(customer);
		phone1.setNumber("+493320312456");
		phone1.setPhoneType(PhoneTypeEnum.HOME.getPhoneType());
		
		Phone phone2 = new Phone();
		phone2.setCustomer(customer);
		phone2.setNumber("+491776773128");
		phone2.setPhoneType(PhoneTypeEnum.MOBILE.getPhoneType());		

		Phone phone3 = new Phone();
		phone3.setCustomer(customer);
		phone3.setNumber("+491776773128");
		phone3.setPhoneType(PhoneTypeEnum.BUSINESS.getPhoneType());
		
		generalDAO.save(phone1,phone2,phone3);
		
	}
}
