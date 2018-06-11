package com.glarimy;

import java.beans.ConstructorProperties;

public class Qualification {
	private String university;
	private String degree;

	public Qualification() {

	}

	@ConstructorProperties({ "university", "degree" })
	public Qualification(String university, String degree) {
		super();
		this.university = university;
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Qualification [university=" + university + ", degree=" + degree + "]";
	}

}
