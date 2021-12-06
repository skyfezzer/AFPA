package fr.afpa.math;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MathBeanTest {
	private static MathBean bean;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bean = new MathBean();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		bean = null;
		System.gc();
	}

	@Test
	void testFactorielle0() {
		assertEquals(BigInteger.ONE,bean.factorielle(BigInteger.ZERO),"fact(0) vaut 1");
	}
	@Test
	void testFactorielle1() {
		assertEquals(BigInteger.ONE,bean.factorielle(BigInteger.ONE),"fact(1) vaut 1");
	}
	@Test
	void testFactorielle20() {
		assertEquals(BigInteger.valueOf(2432902008176640000L),bean.factorielle(BigInteger.valueOf(20)),"fact(20) vaut 2432902008176640000");
	}
	@Test
	void testFactorielle21() {
		assertEquals(new BigInteger("51090942171709440000"),bean.factorielle(BigInteger.valueOf(21)),"fact(21) vaut 51090942171709440000");
	}
	@Test
	void testFactorielleMoins1() {
		//assertEquals(BigInteger.ONE,bean.factorielle(BigInteger.ZERO),"fact(-1) vaut 1");
		assertThrows(IllegalArgumentException.class,() -> bean.factorielle(BigInteger.valueOf(-1)),"fact(-1) renvoie IllegalArgumentException");
	}
	@Test
	void testFactorielle45() {
		assertEquals(new BigInteger("119622220865480194561963161495657715064383733760000000000"),bean.factorielle(BigInteger.valueOf(45)),"fact(45) vaut beaucoup");
	}

}
