package lab08.ex1.b;

class BankAccountProxy extends BankAccountImpl {

	BankAccountProxy(String bank, double initialDeposit) {
		super(bank, initialDeposit);
	}

	@Override
	public boolean withdraw(double amount) {
		if (Company.user == User.OWNER)
			return super.withdraw(amount);
		else
			throw new UnsupportedOperationException("Unauthorized operation!");
	}

	@Override
	public double balance() {
		if (Company.user == User.OWNER)
			return super.balance();
		else
			throw new UnsupportedOperationException("Unauthorized operation!");
	}
}