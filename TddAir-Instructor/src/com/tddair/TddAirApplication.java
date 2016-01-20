package com.tddair;

import java.util.HashMap;
import java.util.Map;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private MemberDao members = new MemberDaoStub();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerAsMember(String userName, String email) {
		if (members.contains(userName)) throw new DuplicateUserNameException("Duplicate username! ");
		Member member = new Member(userName);
		members.register(userName, member);
	}

	public Member lookUpMember(String userName) {
		return members.lookup(userName);
	}
}
