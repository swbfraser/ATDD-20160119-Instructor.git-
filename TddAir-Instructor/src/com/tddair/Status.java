package com.tddair;

public enum Status {
	Red(0), Green(25000), Blue(50000), Gold(75000);

	private int threshold;

	private Status(int threshold) {
		this.threshold = threshold;
	}
	
	public int getThreshold() {
		return threshold;
	}
	
	public static Status calculateStatusFor(int ytdMiles) {
		Status status = Status.Red;

		if (ytdMiles >= Status.Gold.getThreshold()) {
			status = Status.Gold;
		} else if (ytdMiles >= Status.Blue.getThreshold()) {
			status = Status.Blue;
		} else if (ytdMiles >= Status.Green.getThreshold()) {
			status = Status.Green;
		}

		return status;
	}

}
