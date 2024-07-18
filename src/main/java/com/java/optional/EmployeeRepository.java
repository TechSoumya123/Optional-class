package com.java.optional;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

	private EmployeeRepository() {
	}

	public static List<Employee> getEmployeeList() {
		return List.of(
				new Employee(101, "Abhishek", 10), new Employee(177, "Sneh", 55), new Employee(129, "John", 60),
				new Employee(101, "Abhishek", 60), new Employee(153, "Robert", 44), new Employee(102, "Yuvaraj", 90));
	}

	public static Employee populateEmployee() {
		return new Employee(12, "hey check", 234);
	}
	
	public static Employee populateEmployee2() {
		return null;
	}

	public static Optional<Employee> getEmployeeUsingJava8(int marks) {
		return EmployeeRepository.getEmployeeList().stream().filter(employee -> employee.getMarks().equals(marks))
				.findFirst();
	}

}
