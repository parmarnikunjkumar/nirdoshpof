package com.nirdosh.hazelcast.test;

import com.hazelcast.client.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;


public class GettingStartedHazelCast {
	
	public static void main(String[] args){
		
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("localhost:5701");
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		IMap map = client.getMap("customers");
		System.out.println("SIZE:" + map.size());
		
		for(Object str : map.keySet()){
			System.out.println(str);
		}
	}

}
