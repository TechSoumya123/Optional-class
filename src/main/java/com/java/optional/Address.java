package com.java.optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

	private int id;
	private String city;

	public Address() {
		this.id = 100;
		this.city = "Youtube";
	}

	public Address(int id, String city) {
		this.id = id;
		this.city = city;
	}

}
