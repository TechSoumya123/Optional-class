import static java.lang.System.out;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

import com.java.optional.Address;
import com.java.optional.Employee;
import com.java.optional.EmployeeEntity;
import com.java.optional.EmployeeRepo;
import com.java.optional.EmployeeRepository;
import com.java.optional.NoMarksPresentException;

public class First {
	private static final Logger logger = Logger.getLogger(First.class.getName());

	public static void main(String[] args) {

		fetchEmployee(60);

		getEmployee();

		getEmployeeUsingGetMethod();

		// TODO -4 orElse()
		fetchOptionalEmployeeorElse();

		// TODO -5 orElseGet()
		fetchOptionalEmployeeorElseGet();

		// TODO -6 orElseThrow()
		getEmployeeoeElseThrow();

		// TODO -7
		getEmployeeoeElseThrowCustomException();

		// TODO -8 IsPresent()
		getEmployeeIsPresent();

		// TODO -9 IsEmpty()
		getEmployeeIsEmpty();

		// TODO -10 IfPresent()
		getEmployeeIfPresent();

		// TODO -11 IfPresent()
		getEmployeeIfPresentOrElse();

		// TODO -12 of() EmployeeToOptional<Employee>
		fromEmployeeToOptionalEmployee();

		// TODO -13 ofNullable()
		fromEmployeeToOptionalEmployeeWithOfNullable();

		// TODO -14
		getEmployeeByMarks();

		// TODO -15
		convertEmployeeToStringUsingMap();

		// TODO -16
		getEmployeeAddress();

		// TODO -17 flatMap()
		getAdressFromOptionalUsingFlatmap();

	}

	// TODO -1 Traditional Way..

	private static void fetchEmployee(int marks) {
		List<Employee> employeeList = EmployeeRepository.getEmployeeList();
		for (Employee employee : employeeList) {
			if (employee.getMarks().equals(marks)) {
				logger.info(employee.toString());
			}
		}
	}

	// TODO -2

	private static void getEmployee() {
		Optional<Employee> fetch_marks = EmployeeRepository.getEmployeeUsingJava8(60);
		logger.info(() -> fetch_marks.orElse(new Employee()).toString());
	}

	// TODO -3 -get()

	private static void getEmployeeUsingGetMethod() {
		Optional<Employee> get_Method = EmployeeRepository.getEmployeeUsingJava8(60);
		// out.println(usingJava.get());
		logger.info(get_Method.get().toString());
	}

	// TODO -4 - orElse

	private static void fetchOptionalEmployeeorElse() {
		Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(60);
		out.println(employeeUsingJava8.orElse(EmployeeRepository.populateEmployee()));

	}

	// TODO -5 orElseGet

	private static void fetchOptionalEmployeeorElseGet() {
		Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(68);
		out.println(employeeUsingJava8.orElseGet(EmployeeRepository::populateEmployee));

	}

	// TODO -6 orElseThrow() It always throw JVM compiler

	private static void getEmployeeoeElseThrow() {
		try {
			Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(990);
			Employee employee = employeeUsingJava8.orElseThrow();
			out.println(employee);
		} catch (NoSuchElementException exception) {
			out.println(exception);
			out.println(exception.getMessage());
		}
	}

	// TODO -7 orElseThrow(//supplier except () -> new NoMarksPresentException("This
	// marks not present in the database."))

	private static void getEmployeeoeElseThrowCustomException() {
		try {
			Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(69);
			Employee orElseThrow = employeeUsingJava8
					.orElseThrow(() -> new NoMarksPresentException("This marks not present in the database."));
			out.println(orElseThrow);
		} catch (Exception exception) {
			out.println(exception.getMessage());
		}
	}

	// TODO -8 IsPresent()

	private static void getEmployeeIsPresent() {
		Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(60);
		Object object = (employeeUsingJava8.isPresent()) ? employeeUsingJava8.get() : "No employee found";
		out.println(object);
	}

	// TODO -9 IsEmpty()

	private static void getEmployeeIsEmpty() {
		Optional<Employee> employeeUsingJava8 = EmployeeRepository.getEmployeeUsingJava8(600);
		Object object = (employeeUsingJava8.isEmpty()) ? Optional.of("No employee found.....").get()
				: employeeUsingJava8.get();
		out.println(object);
	}

	// TODO -10

	private static void getEmployeeIfPresent() {
		Optional<Employee> findFirst = EmployeeRepository.getEmployeeList().stream()
				.filter(employee -> employee.getMarks().equals(690)).findFirst();
		findFirst.ifPresent(System.out::println);
	}

	// TODO -11

	private static void getEmployeeIfPresentOrElse() {
		Optional<Employee> findAny = EmployeeRepository.getEmployeeList().parallelStream()
				.filter(employee -> employee.getMarks().equals(67)).findAny();
		findAny.ifPresentOrElse(System.out::println,
				() -> System.out.println(new NoMarksPresentException("No employee get this marks").getMessage()));
	}

	// TODO -12 of()

	private static void fromEmployeeToOptionalEmployee() {
		Optional<Employee> employee = Optional.of(EmployeeRepository.populateEmployee());
		employee.ifPresentOrElse(System.out::println, () -> System.out.println("No employee found"));

	}

	// TODO -13 ofNullable()

	private static void fromEmployeeToOptionalEmployeeWithOfNullable() {
		Optional<Employee> employee = Optional.ofNullable(EmployeeRepository.populateEmployee2());
		employee.ifPresentOrElse(System.out::println, () -> System.out.println("No employee found"));
	}

	// TODO - 14

	private static void getEmployeeByMarks() {
		Optional<EmployeeEntity> filtercheck = EmployeeRepo.fetchEmployeeByMarks(90);
		logger.info(filtercheck.get().toString());
		filtercheck.filter(emp -> emp.getAddress().isEmpty()).ifPresentOrElse(System.out::println,
				() -> logger.info(new NoMarksPresentException("ok").toString()));

		filtercheck.filter(emp -> emp.getAddress().isEmpty()).ifPresentOrElse(System.out::println,
				() -> System.out.println("ok"));
	}

	// TODO -15 map()

	private static void convertEmployeeToStringUsingMap() {
		Optional<String> mapName = EmployeeRepo.fetchEmployeeByMarks(69).map(EmployeeEntity::getName);
		System.out.println(mapName.orElseThrow(IllegalArgumentException::new));

		EmployeeRepo.fetchEmployeeByMarks(60).ifPresentOrElse(emp -> System.out.println(emp.getName()),
				() -> logger.info(new NoMarksPresentException("ok").getMessage()));
	}

	// TODO -16 flatMap()

	private static void getEmployeeAddress() {
		try {
			String orElseThrow = EmployeeRepo.fetchEmployeeByMarks(900).flatMap(EmployeeEntity::getAddress)
					.map(Address::getCity).orElseThrow(() -> new NoMarksPresentException("Address is not available.."));
			logger.info(orElseThrow);
		} catch (Exception exception) {
			logger.info(exception.getMessage());
		}

	}

	// TODO -17 flatMap()
	private static void getAdressFromOptionalUsingFlatmap() {
		Optional<Optional<Address>> mapAddress = EmployeeRepo.fetchEmployeeByMarks(90).map(EmployeeEntity::getAddress);

		Optional<String> map = mapAddress.map(address -> address.get().getCity());
		logger.info(() -> map.get());
		logger.info(() -> "...................................");
		Optional<String> map2 = EmployeeRepo.fetchEmployeeByMarks(90).map(EmployeeEntity::getAddress).map(Optional::get)
				.map(Address::getCity);
		if (map2.isPresent()) {
			logger.info(() -> map2.get());
		} else {
			logger.info(() -> String.valueOf("No address present"));
		}

	}

}
