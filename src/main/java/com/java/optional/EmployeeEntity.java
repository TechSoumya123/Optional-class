package com.java.optional;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeEntity {

	private Integer id;
	private String name;
	private Integer marks;
	private Optional<Address> address;

	public EmployeeEntity() {
		this.id = 100;
		this.name = "soumya";
		this.marks = 200;
		this.address = Optional.of(EmployeeRepo.populateAddress());
	}

	public EmployeeEntity(Integer id, String name, int marks, Address address) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.address = Optional.of(address);
	}

	public EmployeeEntity(Integer id, String name, int marks, Optional<Address> address) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}
}
