package exchange;

public class VariableRateCurrency extends AbstractCurrency {

	private double exchangeRateInEuro;

	VariableRateCurrency(String name, double exchangeRateInEuro) {
		super(name);
		this.exchangeRateInEuro = exchangeRateInEuro;
	}

	public void modifyExchangeRateInEuro(double newRate) {
		exchangeRateInEuro = newRate;
	}

	public double exchangeRateInEuro() {
		return exchangeRateInEuro;
	}
}
