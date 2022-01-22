package com.tutorial.webservice.rest;

public class Address {
	public String city;
	public String state;
	public int zip;
	public String country;
	
	/*
	 	{
	 		"city":"new york",
	 		"state":"NY",
	 		"zip":12345,
	 		"country":"USA"
	 	}
	*/
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
