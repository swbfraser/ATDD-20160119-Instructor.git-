package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringFlyer {

	private MemberInfo member;
	private TddAirApplication app;

	@Before
	public void setup() {
		//setup
		String username = "donmc";
		String email = "don@improving.com";
		app = new TddAirApplication();
		app.registerAsMember(username, email);
		
		member = app.lookUpMember(username);
	}
	
	@Test
	public void shouldSaveAsMember() {
		assertNotNull(member);
		assertEquals("donmc", member.getUserName());
	}
	
	@Test
	public void shouldNotFindUnregisteredUserNames() {
		MemberInfo member = app.lookUpMember("some guy");
		assertNull(member);
	}
	
	@Test
	public void shouldSaveTwoMembers() {
		app.registerAsMember("bob", "bob@bobco.com");
		MemberInfo member2 = app.lookUpMember("bob");
		assertEquals("donmc", member.getUserName());
		assertEquals("bob", member2.getUserName());
		
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}

	@Test
	public void shouldHave10000BonusMilesForBalance() {
		assertEquals(10000, member.getBalanceMiles());
	}

	@Test
	public void shouldHave0YtdMiles() { 
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test(expected=DuplicateUserNameException.class)
	public void shouldErrorWithDuplicateUserName() {
		app.registerAsMember("donmc", "blah@blah.com");
	}
}
