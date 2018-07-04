package com.glarimy.spring.api;

import javax.persistence.Entity;

@Entity
public class TextBook extends Book {
	protected String course;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
