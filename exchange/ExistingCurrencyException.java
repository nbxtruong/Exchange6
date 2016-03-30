package exchange;

public class ExistingCurrencyException extends Exception {

	private Currency c;

	public ExistingCurrencyException(Currency c) {
		super("Currency " + c.name() + " yet existing");
		this.c = c;
	}

	public Currency currency() {
		return c;
	}

}

