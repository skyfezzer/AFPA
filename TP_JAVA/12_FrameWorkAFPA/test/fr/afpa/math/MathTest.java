package fr.afpa.math;

import static org.junit.jupiter.api.Assertions.*;
import static fr.afpa.math.Math.factorielle;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MathTest {

	@Test
	@ValueSource
	void testEuroToDollar() {
		assertEquals(new BigDecimal("10.00"),Math.dollarToEuro(Math.euroToDollar(new BigDecimal("10.00"))),"10 Euros valent 11.35 Dollars");
	}

	@Test
	void testDollarToEuro() {
		assertEquals(new BigDecimal("88.14"),Math.dollarToEuro(new BigDecimal("100.00")),"88.14 Dollars valent 100 Euros");
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"0, 1",
		"1, 1",
		"3, 6",
		"20, 2432902008176640000",
	})
	void testFactorielleStandard(long value,long expected) {
		assertEquals(expected,factorielle(value),"CSVSource");
	}
	
	@ParameterizedTest
	@ValueSource(longs= {21,-7})
	void testFactorielleException1(long value) {
		assertThrows(IllegalArgumentException.class, () -> {Math.factorielle(value);});
	}
	

	
	
	

}
