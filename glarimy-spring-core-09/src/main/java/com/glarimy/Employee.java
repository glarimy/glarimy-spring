package com.glarimy;

import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private boolean regular;
	private Role role;
	private Address address;
	private Card card;
	private Set<Qualification> qualifications;

	public Employee() {

	}

	public Employee(int id, String name, double salary, boolean regular, Address address,
			Set<Qualification> qualifications) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.regular = regular;
		this.address = address;
		this.qualifications = qualifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isRegular() {
		return regular;
	}

	public void setRegular(boolean regular) {
		this.regular = regular;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	public static class Role {
		private String designation;

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

	}

}
