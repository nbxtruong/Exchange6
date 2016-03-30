package exchange;

abstract class AbstractCurrency implements Currency {
	private final String name;

	AbstractCurrency(String name) {
		this.name = name;
	}

	public final String name() {
		return name;
	}

	public double convertInEuro(double amount) {
		return amount / exchangeRateInEuro();
	}

	public double convertFromEuro(double amount) {
		return amount * exchangeRateInEuro();
	}
	
	public boolean equals(Object o) {
		return o instanceof AbstractCurrency
				&& name.equals(((AbstractCurrency) o).name);
	}

	public int hashCode() {
		return name.hashCode();
	}

	public String toString() {
		return name;
	}
}
