package com.java.optional;

import java.util.List;
import java.util.Optional;

public class EmployeeRepo {

	private EmployeeRepo() {
	}

	public static List<EmployeeEntity> getEmployeeWithAddress() {
		return List.of(new EmployeeEntity(101, "Abhishek", 10, Optional.of(new Address(1, "Chandigarh"))),
				new EmployeeEntity(177, "Sneh", 55, Optional.ofNullable(new Address(2, "Kolkata"))),
				new EmployeeEntity(129, "John", 60, Optional.ofNullable(null)),
				new EmployeeEntity(101, "Abhishek", 60, Optional.of(new Address(4, "New Delhi"))),
				new EmployeeEntity(153, "Robert", 74, Optional.empty()),
				new EmployeeEntity(102, "Yuvraj", 90, new Address(6, "Chennai")));
	}

	public static Address populateAddress() {
		return new Address();
	}

	public static EmployeeEntity populatEmployeeEntity() {
		return new EmployeeEntity();
	}

	public static Optional<EmployeeEntity> fetchEmployeeByMarks(Integer marks) {
		return getEmployeeWithAddress()
				.stream()
				.filter(emp -> emp.getMarks().equals(marks))
				.findFirst();
	}

}
