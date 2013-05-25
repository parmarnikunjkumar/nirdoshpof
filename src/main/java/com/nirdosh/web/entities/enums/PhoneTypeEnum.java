package com.nirdosh.web.entities.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum PhoneTypeEnum {

	HOME(1),
	BUSINESS(2),
	MOBILE(3);
	
	private static final Map<Integer, PhoneTypeEnum> lookup = new HashMap<Integer, PhoneTypeEnum>();
	
	static{
	
		for(PhoneTypeEnum type: EnumSet.allOf(PhoneTypeEnum.class)) {
			lookup.put(type.getPhoneType(), type);
		}
	}
	
	private Integer phoneType;
	
	PhoneTypeEnum(Integer phoneType) {
		this.phoneType= phoneType;
	}
	
	public Integer getPhoneType() {
		return phoneType;
	}
	
	public static PhoneTypeEnum get(Integer type) {
		return lookup.get(type);
	}
	
}
