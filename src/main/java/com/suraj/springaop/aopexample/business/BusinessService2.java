package com.suraj.springaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.suraj.springaop.aopexample.data.DataService2;

@Service
public class BusinessService2 {
	
	private DataService2 dataService2;
	
	public BusinessService2( DataService2 dataService2) {
		this.dataService2 = dataService2;
	}
	
	// Business Logic
	public int calculateMin() {
		
		int [] data = dataService2.retrieveData();
		
		//throw new RuntimeException("Something Went Wrong");
		
		return Arrays.stream(data).min().orElse(0);
	}
	

}
