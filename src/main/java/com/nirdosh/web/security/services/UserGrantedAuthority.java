package com.nirdosh.web.security.services;

import org.springframework.security.core.GrantedAuthority;

public class UserGrantedAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authority = null;
	
	public UserGrantedAuthority(String auth){
		this.authority = auth;
	}
	
	public String getAuthority() {
		return authority;
	}

}
