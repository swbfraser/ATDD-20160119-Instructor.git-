Feature: Complete Flight
As a member
I want completed flight mileage recorded
so that I can accumulate miles and increase status

Scenario: Red to Green
Given a "Red" member "donmc" with 20000 ytd miles
And completes flight "QF191"
Then member has "Green" status
And member has 27490 ytdMiles
And member has 37490 mile balance