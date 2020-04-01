package fraction;

public class myMain {
    
	public static void main(String[] args) {
	/*	
		Fraction frac = new Fraction(200, 50);
		System.out.println("Citatel = " + frac.getNumerator());
		System.out.println("Jmenovatel = " + frac.getDenominator());
	//	System.out.println(frac.getNumerator() + "/" + frac.getDenominator());
		System.out.println(frac.toString());
		System.out.println("Nejvetsi spol. delitel je " + frac.greatestCommonDivisor());
	}
        */
        int[] frac1 = {1, 2};
        Fraction f1 = Fraction.getInstance(frac1);
        System.out.println("Citatel = " + f1.getNumerator());
	System.out.println("Jmenovatel = " + f1.getDenominator());
	System.out.println(f1);
        System.out.println("Nejvetsi spol. delitel je " + f1.greatestCommonDivisor());
        int[] frac2 = {1, 2};
        Fraction f2 = Fraction.getInstance(frac2);
        System.out.println(f2);
        //int[] m = multiplyFraction(frac1, frac2);
        //System.out.println(m);
        
}
        
}