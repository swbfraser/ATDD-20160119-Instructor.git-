package com.tddair;

public class Member implements MemberInfo {

	private String userName;
	private int ytdMiles;
	private Status status;
	private int balance;

	public Member(String userName) {
		this.userName = userName;
		this.status = Status.Red;
		this.balance = 10000;
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberInfo#getUserName()
	 */
	@Override
	public String getUserName() {
		return userName; 
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberInfo#getYtdMiles()
	 */
	@Override
	public int getYtdMiles() {
		return ytdMiles;
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberInfo#getBalanceMiles()
	 */
	@Override
	public int getBalanceMiles() {
		return balance;
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberInfo#getStatus()
	 */
	@Override
	public Status getStatus() {
		return status;
	}

	public void completeFlight(Flight flight) {
		updateMiles(flight);
		updateStatus();
	}

	private void updateStatus() {
		status = Status.calculateStatusFor(ytdMiles);
	}

	private void updateMiles(Flight flight) {
		int milesFlown = flight.getMileage();
		ytdMiles += milesFlown;
		balance += milesFlown;
	}

}
