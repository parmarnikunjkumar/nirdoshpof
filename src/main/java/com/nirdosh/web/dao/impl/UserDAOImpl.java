package com.nirdosh.web.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.hibernate.GeneralDAO;
import com.googlecode.genericdao.search.Search;
import com.nirdosh.web.dao.UserDAO;
import com.nirdosh.web.entities.User;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	GeneralDAO generalDAO;

	public User loadUserByName(String name) {
		
		Search search = new Search(User.class);
		search.addFilterEqual("name", name);		
		
		User user =(User) generalDAO.search(search).get(0);
		
		return user;
	}

}
