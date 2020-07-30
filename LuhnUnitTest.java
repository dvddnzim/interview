package com.hps.luhn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.math.BigInteger;

public class LuhnUnitTest {

	Luhn luhn;

	@Before
	public void setUp() throws Exception {
		luhn = new Luhn();
	}

	@Test
	public void generateCheckDigit() {
		assertEquals(9, luhn.generateCheckDigit(new BigInteger("92739871")));
		assertEquals(7, luhn.generateCheckDigit(new BigInteger("92739872")));
                assertEquals(5, luhn.generateCheckDigit(new BigInteger("4959591803")));
		assertEquals(3, luhn.generateCheckDigit(new BigInteger("7992739871")));
		assertEquals(4, luhn.generateCheckDigit(new BigInteger("948417766128")));
		assertEquals(6, luhn.generateCheckDigit(new BigInteger("286635141968")));
		assertEquals(1, luhn.generateCheckDigit(new BigInteger("58021710386316")));
		assertEquals(6, luhn.generateCheckDigit(new BigInteger("93852725542205")));
		assertEquals(9, luhn.generateCheckDigit(new BigInteger("7073964599192709")));
		assertEquals(2, luhn.generateCheckDigit(new BigInteger("3515080212530012")));
		assertEquals(3, luhn.generateCheckDigit(new BigInteger("4326126181535606187774638440")));
		assertEquals(5, luhn.generateCheckDigit(new BigInteger("2137748573605769622060541803")));
		assertEquals(0, luhn.generateCheckDigit(new BigInteger("1456585316366091446745363404")));
		assertEquals(6, luhn.generateCheckDigit(new BigInteger("1048703718713673368555398477")));
		assertEquals(9, luhn.generateCheckDigit(new BigInteger("8927508431178319262312495658")));
	}

	@Test
	public void isValidLuhn() {
		assertFalse(luhn.isValidLuhn(new BigInteger("927398710")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398711")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398712")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398713")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398714")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398715")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398716")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398717")));
		assertFalse(luhn.isValidLuhn(new BigInteger("927398718")));
		assertTrue(luhn.isValidLuhn(new BigInteger("927398719")));

                // Check these randomly generated valid nums.
		assertTrue(luhn.isValidLuhn(new BigInteger("3666141787")));
		assertTrue(luhn.isValidLuhn(new BigInteger("9056473144")));
		assertTrue(luhn.isValidLuhn(new BigInteger("8686769939")));
		assertTrue(luhn.isValidLuhn(new BigInteger("1675391054")));

                // Modify the valid nums slightly and make
                // sure they are no longer valid.
		assertFalse(luhn.isValidLuhn(new BigInteger("3666141788")));
		assertFalse(luhn.isValidLuhn(new BigInteger("9056473145")));
		assertFalse(luhn.isValidLuhn(new BigInteger("8686769938")));
		assertFalse(luhn.isValidLuhn(new BigInteger("1675391055")));

		assertTrue(luhn.isValidLuhn(new BigInteger("4326126181535606187774638440")));
		assertTrue(luhn.isValidLuhn(new BigInteger("2137748573605769622060541803")));
		assertTrue(luhn.isValidLuhn(new BigInteger("1456585316366091446745363404")));
		assertTrue(luhn.isValidLuhn(new BigInteger("1048703718713673368555398477")));
		assertTrue(luhn.isValidLuhn(new BigInteger("8927508431178319262312495658")));

		assertFalse(luhn.isValidLuhn(new BigInteger("4326126181535606187774638441")));
		assertFalse(luhn.isValidLuhn(new BigInteger("2137748573605769622060541804")));
		assertFalse(luhn.isValidLuhn(new BigInteger("1456585316366091446745363405")));
		assertFalse(luhn.isValidLuhn(new BigInteger("1048703718713673368555398478")));
		assertFalse(luhn.isValidLuhn(new BigInteger("8927508431178319262312495659")));
	}

	@Test
	public void countRange() {
		assertEquals(1, luhn.countRange(new BigInteger("927398710"), new BigInteger("927398720")));
		assertEquals(2, luhn.countRange(new BigInteger("927398710"), new BigInteger("927398730")));
		assertEquals(4, luhn.countRange(new BigInteger("8927508431178319262312495659"), new BigInteger("8927508431178319262312495700")));
	}

}
