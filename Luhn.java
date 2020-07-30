package com.hps.luhn;

import java.math.BigInteger;

/**
 * @see https://en.wikipedia.org/wiki/Luhn_algorithm#Description
 */
public class Luhn {

        private static final BigInteger BIG1  = new BigInteger("1");
        private static final BigInteger BIG10 = new BigInteger("10");

	/**
	 * TODO
	 * 
	 * Accepts a card number and determines if the card number is a valid number
	 * with respect to the Luhn algorithm.
	 * 
	 * @param cardNumber
	 *            the card number
         *            Card numbers are generally 16 digits, so this needs to be a BigInteger.
	 * 
	 * @return true if the card number is valid according to the Luhn algorithm,
	 *         false if not
	 */
	public boolean isValidLuhn(BigInteger cardNumber) {
                // Just ensure that the GCD matches the last digit.
		return (cardNumber.mod(BIG10).intValue() == this.generateCheckDigit(cardNumber.divide(BIG10)));
	}

	/**
	 * Accepts a partial card number (excluding the last digit) and generates
	 * the appropriate Luhn check digit for the number.
	 * 
	 * @param cardNumber
	 *            the card number (not including a check digit)
         *            Card numbers are generally 16 digits, so this needs to be a BigInteger.
	 * 
	 * @return the check digit
	 */
	public int generateCheckDigit(BigInteger cardNumber) {
		boolean doubleDigit = true;
		int sum = 0;
		while (cardNumber.compareTo(BigInteger.ZERO) > 0) {
			// starting from the right (rightmost is the unknown check digit)
			int digit = cardNumber.mod(BIG10).intValue(); 

			if (doubleDigit) { // double the value of every second digit
				digit *= 2;

				// if two digits, use the sum of the digits
                                // NOTE: The number 10 is 2 digits.
				if (digit >= 10) {
					digit = digit / 10 + digit % 10; 
				}
			}
			doubleDigit = !doubleDigit;

			sum += digit;

			cardNumber = cardNumber.divide(BIG10); // remaining digits to the left
		}

		return sum * 9 % 10;
	}

	/**
	 * TODO
	 * 
	 * Accepts two card numbers representing the starting and ending numbers of
	 * a range of card numbers and counts the number of valid Luhn card numbers
	 * that exist in the range, inclusive.
	 * 
	 * @param startRange
	 *            the starting card number of the range (may not be valid luhn)
         *            DZIMM: This is ambiguous. What does "may not" mean? That it might
         *                   not be valid, or that it's not allowed to be valid? If it's
         *                   valid, what are we supposed to do? Return an error?
	 * @param endRange
	 *            the ending card number of the range (may not be a valid luhn)
         *            Card numbers are generally 16 digits, so these need to be a BigInteger.
	 * 
	 * @return the number of valid Luhn card numbers in the range, inclusive
	 */
	public int countRange(BigInteger startRange, BigInteger endRange) {
                int numValid = 0;
                for (BigInteger l = startRange; l.compareTo(endRange) <= 0; l = l.add(BIG1))
                {
                  if (this.isValidLuhn(l))
                  {
                    numValid++;
                  }
                }
		return numValid;
	}
}
