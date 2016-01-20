package com.tddair.features;

import static org.junit.Assert.*;

import com.tddair.DuplicateUserNameException;
import com.tddair.Member;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterFlyer {
	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String errorMessage;
	
	@When("^a flyer with username \"([^\"]*)\" and email \"([^\"]*)\" registers$")
	public void a_flyer_with_username_and_email_registers(String userName, String email) throws Throwable {
		
		try {
			app.registerAsMember(userName, email);
		} catch (DuplicateUserNameException e) {
			this.errorMessage = e.getMessage();
		}
		
	}

	@Then("^system has member with username \"([^\"]*)\"$")
	public void system_has_member_with_username(String userName) throws Throwable {
	    member = app.lookUpMember(userName);
	    assertNotNull(member);
	}

	@Then("^member has \"([^\"]*)\" status$")
	public void member_has_status(String status) throws Throwable {
	    assertEquals(status, member.getStatus().toString());
	}

	@Then("^member has (\\d+) ytdMiles$")
	public void member_has_ytdMiles(int ytdMiles) {
	   assertEquals(ytdMiles, member.getYtdMiles());
	}

	@Then("^member has (\\d+) mile balance$")
	public void member_has_mile_balance(int balance) throws Throwable {
		   assertEquals(balance, member.getBalanceMiles());
	}

	@Then("^error \"([^\"]*)\" is returned$")
	public void error_is_returned(String expectedErrorMessage) throws Throwable {
	    assertEquals(expectedErrorMessage, errorMessage);
	}


}
