import exchange.Currency;
import exchange.Exchange;
import exchange.UnknownCurrencyException;

public class TestExchange {

	public static void main(String[] args) {
		double amountToConvert = Double.valueOf(args[0]).doubleValue();
		String currencyName = args[1];

		try {
			System.out.println(Exchange.currency(currencyName).convertInEuro(
					amountToConvert)
					+ " Euros");
		} catch (UnknownCurrencyException e) {
			Currency[] currencies = Exchange.processedCurrencies();
			System.out.print("Currency " + e.name()
					+ " unknown (processed currencies =");
			for (int i = 0; i < currencies.length; ++i) {
				System.out.print(" " + currencies[i].name());
			}
			System.out.println(")");
		}
	}
}
