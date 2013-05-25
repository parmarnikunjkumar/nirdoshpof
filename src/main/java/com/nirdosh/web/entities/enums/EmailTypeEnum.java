package com.nirdosh.web.entities.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EmailTypeEnum {
	
	PRIVATE(1),
	BUSINESS(2);
	
	private static final Map<Integer, EmailTypeEnum> lookup = new HashMap<Integer, EmailTypeEnum>();
	
	static{
	
		for(EmailTypeEnum type: EnumSet.allOf(EmailTypeEnum.class)) {
			lookup.put(type.getEmailType(), type);
		}
	}
	
	private Integer emailType;
	
	EmailTypeEnum(Integer addressType) {
		this.emailType= addressType;
	}
	
	public Integer getEmailType() {
		return emailType;
	}
	
	public static EmailTypeEnum get(Integer type) {
		return lookup.get(type);
	}

}
