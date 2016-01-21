Feature: Register Flyer
As a frequent flyer
I want to register for an account
so that I can begin collecting miles for rewards

Scenario: Clean Up
Given a new system

Scenario: Happy Path

When a flyer with username "donmc" and email "don@improving.com" registers

Then system has member with username "donmc"
And member "donmc" has "Red" status
And member "donmc" has 0 ytd miles
And member "donmc" has 10000 balance miles

Scenario: Duplicate User Name

Given a flyer with username "donmc" and email "don@improving.com" registers
When a flyer with username "donmc" and email "don@gamil.com" registers
Then error "Duplicate username!" is returned
