package com.nirdosh.web.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-datasource-applicationContext.xml")
@TransactionConfiguration(transactionManager="nirdoshTxManager")
public class AbstractTest {

	@Autowired
	protected GeneralDAO generalDAO;
}
