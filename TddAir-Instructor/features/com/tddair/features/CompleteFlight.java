package com.tddair.features;

import com.tddair.MemberInfo;
import com.tddair.TddAirApplication;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CompleteFlight {

	private TddAirApplication app = TddAirAppSingleton.getInstance();
	private MemberInfo member;
	
	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with (\\d+) ytd miles$")
	public void a_member_with_ytd_miles(String status, String userName, int ytdMiles) {
		app.registerAsMember(userName, "don@don.com");
		app.addFlight("DFW", "DDD", ytdMiles, "AA", 2222);
		app.completeFlight(userName, "AA2222");
		member = app.lookUpMember(userName);
	}

	@When("^they complete flight \"([^\"]*)\"$")
	public void they_complete_flight(String flightNumber) throws Throwable {
		app.completeFlight(member.getUserName(), flightNumber);
		
	}
}
