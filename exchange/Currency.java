package exchange;

/**
 * The interface Currency allows to create objects representing the curreny of a
 * country.
 * Each currency is characterized by its name and contains as data its exchange
 * rate in euro.
 * This class gives also methods allowing to convert an amount from the currency
 * to euro and reverse.
 */

public interface Currency {

	public String name();

	public double exchangeRateInEuro();

	public double convertInEuro(double amount);

	public double convertFromEuro(double amount);

}

