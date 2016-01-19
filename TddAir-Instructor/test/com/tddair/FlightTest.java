package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FlightTest {


	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithNoOrigin() {
		new Flight(null, "DFW", 1203);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExceptionThrownWithInvalidOrigin() {
		new Flight("DALLAS", "DFW", 1203);
	}

	@Test
	public void testExceptionThrownWithNoDestination() {
		try {
			new Flight("DFW", null, 1231);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}

	@Test 
	public void testGetFullFlightNumber() { 
		// setup  
		Flight flight = new Flight("DFW", "SAN", 400, "AA", 1234);
		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("AA1234", fullFlightNumber);
	}
	
	@Test 
	public void testGetFullFlightNumber_NoFlightNo() { 
		// setup  
		Flight flight = new Flight("DFW", "SAN", 400, null, 0);
		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		
		// verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	@Test 
	public void testGetFlightInfo() { 
		// setup  
		Flight flight = new Flight("DFW", "ORD", 923, "AA", 453);
		// exercise
		String flightInfo = flight.getInfo();
		
		// verify
		assertEquals("AA453 | DFW -> ORD | 923 miles", flightInfo);
	}
	
	@Test 
	public void testGetFlightInfoForMoreFlights() { 
		// setup  
		Flight flight = new Flight("MIA", "LAX", 3000, "WN", 2311);
		// exercise
		String flightInfo = flight.getInfo();
		
		// verify
		assertEquals("WN2311 | MIA -> LAX | 3000 miles", flightInfo);
	}

}
