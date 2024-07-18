package com.java.optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

	private Integer id;
	private String name;
	private Integer marks;

	public Employee() {
		super();
		this.id = 7;
		this.name = "Soumya";
		this.marks = 100;
	}

	public Employee(Integer id, String name, Integer marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	

}
