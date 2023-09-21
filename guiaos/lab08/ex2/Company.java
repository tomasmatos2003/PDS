package lab08.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

	public static User user;
	private List<Employee> emps;
	private List<EmployeeCard> cards;
	private SocialSecurity socialSecurity;
	private Insurance insurance;
	private Parking parking;

	public Company() {
		this.emps = new ArrayList<>();
		this.socialSecurity = new SocialSecurity();
		this.insurance = new Insurance();
		this.parking = new Parking();
	}

	private double averageSalary() {
		double sum = 0;
		for (Employee e : emps) {
			sum += e.getSalary();
		}
		return sum / emps.size();
	}

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);
		EmployeeCard card = new EmployeeCard(person.getName());
		cards.add(card);
		socialSecurity.regist(person);
		insurance.regist(person);
		if (salary > averageSalary())
			parking.allow(person);
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getPerson().getBankAccount();
			ba.deposit(e.getSalary());
		}
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}