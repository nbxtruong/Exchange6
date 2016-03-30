package exchange;

public class UnknownCurrencyException extends Exception {

	private String name;

	public UnknownCurrencyException(String name) {
		super("Currency " + name + " unknown");
		this.name = name;
	}

	public String name() {
		return name;
	}

}
