package fr.afpa.math;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class MathTest {

	@Test
	void testEuroToDollar() {
		assertEquals(new BigDecimal("10.00"),Math.dollarToEuro(Math.euroToDollar(new BigDecimal("10.00"))),"10 Euros valent 11.35 Dollars");
	}

	@Test
	void testDollarToEuro() {
		assertEquals(new BigDecimal("88.14"),Math.dollarToEuro(new BigDecimal("100.00")),"88.14 Dollars valent 100 Euros");
	}
	
	@Test
	void testFactorielle1() {
		assertEquals(1L,Math.factorielle(0),"factorielle(0) vaut 1");
	}
	@Test
	void testFactorielle2() {
		assertEquals(1L,Math.factorielle(1),"factorielle(1) vaut 1");
	}
	@Test
	void testFactorielle3() {
		assertEquals(2432902008176640000L,Math.factorielle(20),"factorielle(20) vaut 2432902008176640000");
	}
	@Test
	void testFactorielle5() {
		assertEquals(24L,Math.factorielle(4),"factorielle(4) vaut 24");
	}
	@Test
	void testFactorielle6() {
		assertEquals(120L,Math.factorielle(5),"factorielle(5) vaut 120");
	}
	
	@Test
	void testFactorielleException1() {
		assertThrows(IllegalArgumentException.class, () -> {Math.factorielle(21);});
	}
	

	
	
	

}
