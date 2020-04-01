package fraction;

public class Fraction {
	
	//data
    private int[] fraction;
    
    private Fraction(int[] fraction) { //defenzivni kopie
        int[] fractionTemp = new int[fraction.length];
        System.arraycopy(fraction, 0, fractionTemp, 0, fraction.length);
        this.fraction = fractionTemp;
    }
    
    public static Fraction getInstance(int... fraction) { //[3, 0, 2, 5]
        return new Fraction(fraction);
    }
    
    public int getNumerator() {
        return fraction[0];
    }

    public int getDenominator() {
        return fraction[1];
    }

    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }

	
	public Fraction(int numerator, int denominator) {
		if (1 > numerator || denominator < 1) {
			throw new IllegalArgumentException("Citatel nebo jmenoval nesmi byt roven 0.");
		}
		this.fraction[0] = numerator;
		this.fraction[1] = denominator;
	}
	
	
	
	//setters .. momentalne nepouzity
	public void setNumerator(int numerator) {
		this.fraction[0] = numerator;
	}
	public void setDenominator(int denominator) {
		this.fraction[1] = denominator;
	}
	
	//methods
	public int greatestCommonDivisor() {
		int a = getNumerator();
		int b = getDenominator();
		int temp = 0;
		
		if (a == b) return a;
		
		
		while(b > 0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
        

}

