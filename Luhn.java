package com.hps.luhn;

/**
 * @see https://en.wikipedia.org/wiki/Luhn_algorithm#Description
 */
public class Luhn {

	/**
	 * TODO
	 * 
	 * Accepts a card number and determines if the card number is a valid number
	 * with respect to the Luhn algorithm.
	 * 
	 * @param cardNumber
	 *            the card number
         *            Card numbers are generally 16 digits, so this needs to be a long
	 * 
	 * @return true if the card number is valid according to the Luhn algorithm,
	 *         false if not
	 */
	public boolean isValidLuhn(long cardNumber) {
                // Just ensure that the GCD matches the last digit.
		return (this.generateCheckDigit(cardNumber / 10) == (cardNumber % 10));
	}

	/**
	 * Accepts a partial card number (excluding the last digit) and generates
	 * the appropriate Luhn check digit for the number.
	 * 
	 * @param cardNumber
	 *            the card number (not including a check digit)
         *            Card numbers are generally 16 digits, so this needs to be a long
	 * 
	 * @return the check digit
	 */
	public int generateCheckDigit(long cardNumber) {
		boolean doubleDigit = true;
		int sum = 0;
		while (cardNumber > 0) {
			// starting from the right (rightmost is the unknown check digit)
			long digit = cardNumber % 10; 

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

			cardNumber /= 10; // remaining digits to the left
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
         *            Card numbers are generally 16 digits, so these need to be a long
	 * 
	 * @return the number of valid Luhn card numbers in the range, inclusive
	 */
	public int countRange(long startRange, long endRange) {
                int numValid = 0;
                for (long l = startRange; l <= endRange; l++)
                {
                  if (this.isValidLuhn(l))
                  {
                    numValid++;
                  }
                }
		return numValid;
	}
}
