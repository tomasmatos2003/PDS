package lab08.ex1.a;

class Person {

	private String name;
	private BankAccount bankAccount;

	public Person(String n) {
		name = n;
		bankAccount = new BankAccountProxy("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
}