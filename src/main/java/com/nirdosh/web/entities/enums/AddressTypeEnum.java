package com.nirdosh.web.entities.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum AddressTypeEnum {
	
	HOME(1),
	BUSINESS(2);
	
	private static final Map<Integer, AddressTypeEnum> lookup = new HashMap<Integer, AddressTypeEnum>();
	
	static{
	
		for(AddressTypeEnum type: EnumSet.allOf(AddressTypeEnum.class)) {
			lookup.put(type.getAddressType(), type);
		}
	}
	
	private Integer addressType;
	
	AddressTypeEnum(Integer addressType) {
		this.addressType= addressType;
	}
	
	public Integer getAddressType() {
		return addressType;
	}
	
	public static AddressTypeEnum get(Integer type) {
		return lookup.get(type);
	}
	
}
