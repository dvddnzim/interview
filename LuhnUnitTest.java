package com.hps.luhn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class LuhnUnitTest {

	Luhn luhn;

	@Before
	public void setUp() throws Exception {
		luhn = new Luhn();
	}

	@Test
	public void generateCheckDigit() {
		assertEquals(9, luhn.generateCheckDigit(92739871));
		assertEquals(7, luhn.generateCheckDigit(92739872));
                assertEquals(5, luhn.generateCheckDigit(4959591803L));
		assertEquals(3, luhn.generateCheckDigit(7992739871L));
		assertEquals(4, luhn.generateCheckDigit(948417766128L));
		assertEquals(6, luhn.generateCheckDigit(286635141968L));
		assertEquals(1, luhn.generateCheckDigit(58021710386316L));
		assertEquals(6, luhn.generateCheckDigit(93852725542205L));
		assertEquals(9, luhn.generateCheckDigit(7073964599192709L));
		assertEquals(2, luhn.generateCheckDigit(3515080212530012L));
	}

        @Ignore("isValidLuhn not ready yet")
	@Test
	public void isValidLuhn() {
		assertFalse(luhn.isValidLuhn(927398710));
		assertFalse(luhn.isValidLuhn(927398711));
		assertFalse(luhn.isValidLuhn(927398712));
		assertFalse(luhn.isValidLuhn(927398713));
		assertFalse(luhn.isValidLuhn(927398714));
		assertFalse(luhn.isValidLuhn(927398715));
		assertFalse(luhn.isValidLuhn(927398716));
		assertFalse(luhn.isValidLuhn(927398717));
		assertFalse(luhn.isValidLuhn(927398718));
		assertTrue(luhn.isValidLuhn(927398719));
	}

        @Ignore("countRange not ready yet")
	@Test
	public void countRange() {
		assertEquals(1, 927398710, 927398720);
	}

}
