package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private Member member;

	@Before
	public void setup() {
		//setup
		String username = "donmc";
		String email = "don@improving.com";
		TddAirApplication app = new TddAirApplication();
		app.registerAsMember(username, email);
		
		member = app.lookUpMember(username);
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("donmc", member.getUserName());
	}

	@Ignore
	@Test
	public void shouldHaveRedStatus() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void shouldHave10000BonusMilesForBalance() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void shouldHave0YtdMiles() {
		fail("Not yet implemented");
	}
}
