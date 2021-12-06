package fr.afpa.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import static fr.afpa.util.UtilitaireBookstore.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UtilitaireBookstoreTest {
	static LocalDate now;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		now = LocalDate.of(2021, 12, 06);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testIsPretEnRetardVrai() {
		assertTrue(isPretEnRetard(LocalDate.of(2021, 10, 5),LocalDate.of(2021, 11, 5),15),"Au 05.11.21, le prêt du 05.10.21 est en retard.");
	}
	
	@Test
	void testIsPretEnRetardFaux() {
		assertFalse(isPretEnRetard(LocalDate.of(2021, 10, 5),LocalDate.of(2021, 10, 12),15),"Au 12.10.21, le prêt du 05.10.21 n'est pas en retard.");
	}
	
	@ParameterizedTest
	@CsvSource({ 
		"23, 1998,10,11,Une personne née le 11/10/1998 a 23 ans.",
		"10, 2011,05,04,Une personne née le 04/05/2011 a 10 ans.",
		"48, 1973,10,24,Une personne née le 24/10/1973 a 48 ans."})
	void testGetAge(int age, int yyyy, int mm, int dd,String message) {
		assertEquals(age,getAge(LocalDate.of(yyyy, mm, dd), now),message);
	}
	
	@Test
	void testGetAgeInvalide() {
		assertThrows(IllegalArgumentException.class,()->getAge(LocalDate.of(2022, 04, 01),now),"Une date pas encore arrivée renvoie IllegalArgumentException.");
	}

}
