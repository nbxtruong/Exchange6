package exchange;

public class FixedRateCurrency extends AbstractCurrency {

	private final double exchangeRateInEuro;
	
	FixedRateCurrency(String name, double exchangeRateInEuro) {
		super(name);
		this.exchangeRateInEuro = exchangeRateInEuro;
	}
	
	public final double exchangeRateInEuro() {
		return exchangeRateInEuro;
	}
}
