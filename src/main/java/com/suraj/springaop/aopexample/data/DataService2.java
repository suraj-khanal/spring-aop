package com.suraj.springaop.aopexample.data;

import org.springframework.stereotype.Repository;

import com.suraj.springaop.aopexample.annotations.TrackTime;

@Repository
public class DataService2 {
	
	@TrackTime
	public int[] retrieveData() {
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new int[] {111, 222, 333, 444, 555};
	}
}
