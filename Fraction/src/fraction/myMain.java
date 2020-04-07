package fraction;

public class myMain {
    
	public static void main(String[] args) {
	
        int[] frac1 = {2, 3};
        Fraction f1 = Fraction.getInstance(frac1);
        System.out.println("Citatel = " + f1.getNumerator());
	System.out.println("Jmenovatel = " + f1.getDenominator());
	System.out.println(f1);
        int[] frac2 = {2, 3};
        Fraction f2 = Fraction.getInstance(frac2);
        System.out.println(f2);
        Fraction addition = CalculatorFractions.divisionFraction(f1, f2);
        addition.greatestCommonDivisor();
            System.out.println(addition);
        //int[] m = multiplyFraction(frac1, frac2);
        //System.out.println(m);
        
}
        
}