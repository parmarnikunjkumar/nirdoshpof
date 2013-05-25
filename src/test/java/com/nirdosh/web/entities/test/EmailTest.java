package com.nirdosh.web.entities.test;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.nirdosh.web.entities.Customer;
import com.nirdosh.web.entities.Email;
import com.nirdosh.web.entities.enums.EmailTypeEnum;
import com.nirdosh.web.test.AbstractTest;

@Transactional
public class EmailTest extends AbstractTest {

	@Test
	@Rollback(false)
	public void createEmails() {

		Customer customer = generalDAO.find(Customer.class, 1);

		Email email = new Email();

		email.setCustomer(customer);
		email.setEmailAddress("nirdoshbhulku@googlemail.com");
		email.setEmailType(EmailTypeEnum.PRIVATE.getEmailType());

		Email email1 = new Email();

		email1.setCustomer(customer);
		email1.setEmailAddress("parmar.nikunjkumar@googlemail.com");
		email1.setEmailType(EmailTypeEnum.BUSINESS.getEmailType());
		
		generalDAO.save(email,email1);

	}
}
