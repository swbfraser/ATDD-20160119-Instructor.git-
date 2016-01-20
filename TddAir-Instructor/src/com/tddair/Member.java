package com.tddair;

public class Member {

	private String userName;

	public Member(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName; 
	}

	public int getYtdMiles() {
		return 0;
	}

	public int getBalanceMiles() {
		return 10000;
	}

	public Status getStatus() {
		return Status.Red;
	}

}
