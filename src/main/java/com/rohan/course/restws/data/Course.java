package com.rohan.course.restws.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Corse")
public class Course {

	private long id;
	private String name;
	private String taughtBy;
	private long price;
	private double rating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaughtBy() {
		return taughtBy;
	}

	public void setTaughtBy(String taughtBy) {
		this.taughtBy = taughtBy;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
