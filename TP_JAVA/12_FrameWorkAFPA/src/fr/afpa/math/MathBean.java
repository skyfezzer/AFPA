package fr.afpa.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class MathBean{
	public static final BigDecimal EUR_USD_RATE = new BigDecimal("1.1346");
	
	public static BigDecimal euroToDollar(BigDecimal euro) {
		return roundToCents(euro.multiply(EUR_USD_RATE));
	}
	public static BigDecimal dollarToEuro(BigDecimal dollar) {
		return roundToCents(dollar.divide(EUR_USD_RATE,10,RoundingMode.HALF_EVEN));
	}
	
	private static BigDecimal roundToCents(BigDecimal money) {
		return money.setScale(2,RoundingMode.HALF_DOWN);
	}
	
	
	public static void main(String[] args) {
		MathBean mb = new MathBean();
		System.out.println("Factorielle(0) = " + mb.factorielle(BigInteger.ZERO));

		System.out.println("Factorielle(1) = " + mb.factorielle(BigInteger.ONE));

		System.out.println("Factorielle(20) = " + mb.factorielle(BigInteger.valueOf(20)));

		System.out.println("Factorielle(21) = " + mb.factorielle(BigInteger.valueOf(21)));
		try {
		System.out.println("Factorielle(-1) = " + mb.factorielle(BigInteger.valueOf(-1)));
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Factorielle(45) = " + mb.factorielle(BigInteger.valueOf(45)));
		
	}
	/**
	 * Cette méthode utilise une boucle FOR pour trouver la factorielle.
	 * @param entier <code>long</code> nombre dont on cherche la factorielle
	 * @return La factorielle
	 * @throws IllegalArgumentException si un nombre négatif est passé en entrée ou si le nombre cible est supérieur à 21
	 */
	public long factorielleFor(long entier) {
		if(entier <= 1) {
			if(entier < 0) {
				return -1;
			}
			return 1;
		}
		if(entier >= 21) {
			throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre > 21.");
		}
		
		long result = entier;
		for(long i = entier;i>1;i--) {
			result *= i-1;
		}
		return result;
	}
	
	/**
	 * Cette méthode utilise la récursivité pour trouver la factorielle.
	 * @param entier <code>long</code> nombre dont on cherche la factorielle
	 * @return La factorielle
	 * @throws IllegalArgumentException si un nombre négatif est passé en entrée ou si le nombre cible est supérieur à 21
	 */
	public long factorielle(long entier) {
		if(entier <= 1) {
			if(entier < 0) {
				throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre négatif");
			}
			return 1;
		}
		if(entier >= 21) {
			throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre > 21.");
		}
		
		return entier*(factorielle(entier-1));
	}
	
	public BigInteger factorielle(BigInteger entier) {
		if(entier.compareTo(new BigInteger("1")) <= 0) {
			if(entier.compareTo(new BigInteger("0")) < 0) {
				throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre négatif");
			}
			return new BigInteger("1");
		}
		/*if(entier >= 21) {
			throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre > 21.");
		}*/
		
		return entier.multiply(factorielle(entier.subtract(new BigInteger("1"))));
	}
	
	public BigInteger factorielleFor(BigInteger entier) {
		if(entier.compareTo(new BigInteger("1")) <= 0) {
			if(entier.compareTo(new BigInteger("0")) <= 0) {
				throw new IllegalArgumentException("Ne peut pas calculer la factorielle d'un nombre négatif");
			}
			return new BigInteger("1");
		}
		
		BigInteger result = entier;
		BigInteger big1 = new BigInteger("1");
		for(BigInteger i = entier;i.compareTo(big1) > 0;i=i.subtract(big1)) {
			result = result.multiply(i.subtract(big1));
		}
		return result;
	}
	
	
}
