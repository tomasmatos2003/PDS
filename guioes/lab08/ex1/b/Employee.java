package lab08.ex1.b;

class Employee {

	private Person person;
	private double salary;
	
	public Employee(Person p, double s) {
		this.person = p;
		this.salary = s;
	}

	public Person getPerson() {
		return this.person;
	}

	public double getSalary() {
		return salary;
	}
}