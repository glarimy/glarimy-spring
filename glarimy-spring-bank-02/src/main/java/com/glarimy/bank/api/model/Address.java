package com.glarimy.bank.api.model;

public class Address {
	private String location;
	private String city;
	private int pincode;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [location=" + location + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
