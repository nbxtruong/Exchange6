package exchange;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Exchange allows to convert an amount in euro.
 * 
 * Version 6.
 */

public class Exchange {

	/*
	 * This version resolve the problem of currencies with fixed rate.
	 * 
	 * The problem of efficiency of the method currency(String) still remains.
	 */
	private static final List<Currency> CURRENCIES = new ArrayList<Currency>();

	static {
		String[] names = { "Franc", "Mark", "Dollard", "Euro" };
		double[] rates = { 6.55957, 1.95583, 1.2713, 1. };
		boolean[] variables = { false, false, true, true };

		for (int i = 0; i < names.length; ++i) {
			try {
				addCurrency(names[i], rates[i], variables[i]);
			} catch (ExistingCurrencyException e) {
				throw new Error(e.getMessage());
			}
		}
	}

	public static Currency currency(String name)
			throws UnknownCurrencyException {
		for (Currency c : CURRENCIES) {
			if (c.name().equals(name)) {
				return c;
			}
		}
		throw new UnknownCurrencyException(name);
	}

	public static boolean processedCurrency(String name) {
		try {
			currency(name);
			return true;
		} catch (UnknownCurrencyException e) {
			return false;
		}
	}

	public static Currency[] processedCurrencies() {
		return CURRENCIES.toArray(new Currency[CURRENCIES.size()]);
	}

	public static void addCurrency(String name, double exchangeRate,
			boolean variable) throws ExistingCurrencyException {
		try {
			Currency c = currency(name);
			throw new ExistingCurrencyException(c);
		} catch (UnknownCurrencyException e) {
			CURRENCIES.add(variable ? new VariableRateCurrency(name,
					exchangeRate) : new FixedRateCurrency(name, exchangeRate));
		}
	}

	public static void addFixedRateCurreny(String name, double exchangeRate)
			throws ExistingCurrencyException {
		addCurrency(name, exchangeRate, false);
	}

	public static void addVariableRateCurreny(String name, double exchangeRate)
			throws ExistingCurrencyException {
		addCurrency(name, exchangeRate, true);
	}
}
