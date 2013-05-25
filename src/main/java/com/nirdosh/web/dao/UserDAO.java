package com.nirdosh.web.dao;

import com.nirdosh.web.entities.User;


public interface UserDAO {

	 User loadUserByName(String name);
}
