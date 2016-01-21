package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenCompletingFlight {

	private TddAirApplication app;
	private MemberInfo member;

	@Before
	public void setup() {
		app = new TddAirApplication();
		app.addFlight("DFW", "SRI", 25000, "TEST", 25000);
		app.registerAsMember("bob", "bob@bobco.com");
		member = app.lookUpMember("bob");
	}
	
	@Test
	public void shouldGetToGreenStatus() {
		app.completeFlight("bob", "TEST25000");
		
		assertEquals(Status.Green, member.getStatus());
		assertEquals(25000, member.getYtdMiles());
		assertEquals(35000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldGetToBlueStatus() {
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		
		assertEquals(Status.Blue, member.getStatus());
		assertEquals(50000, member.getYtdMiles());
		assertEquals(60000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldGetToGoldStatus() {
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		app.completeFlight("bob", "TEST25000");
		
		assertEquals(Status.Gold, member.getStatus());
		assertEquals(75000, member.getYtdMiles());
		assertEquals(85000, member.getBalanceMiles());
	}
}
