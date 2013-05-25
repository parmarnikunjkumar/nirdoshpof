package com.nirdosh.web.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nirdosh.web.dao.UserDAO;
import com.nirdosh.web.entities.User;
@Service
public class UserLoginService implements UserDetailsService{

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDAO.loadUserByName(name);
		if(user == null) return null;
		
		GrantedAuthority grantedAuth = new UserGrantedAuthority(user.getRole());
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(grantedAuth);
		
		CustomUser customUser = new CustomUser(user.getId(), user.getUserName(), user.getPassword(), authorities);
		
		return customUser;
	}

}
