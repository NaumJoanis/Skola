package fraction;

public class CalculatorFractions {

    public static Fraction multiplyFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getNumerator();
        
        return Fraction.getInstance(sum);
    }

    public static Fraction sumFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();


        return Fraction.getInstance(sum);
    }
    
    public static Fraction subtractionFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();


        return Fraction.getInstance(sum);
    }
    public static Fraction divisionFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getNumerator();
        sum[0] = a.getNumerator() * b.getDenominator();

       
        return Fraction.getInstance(sum);
    }

    public static void main(String[] args) {

        int[] frac1 = {2, 3};
        Fraction f1 = Fraction.getInstance(frac1);
        System.out.println("Citatel = " + f1.getNumerator());
        System.out.println("Jmenovatel = " + f1.getDenominator());
        System.out.println(f1);

        int[] frac2 = {2, 3};
        Fraction f2 = Fraction.getInstance(frac2);
        System.out.println(f2);
        System.out.println(multiplyFraction(f1, f2));
        System.out.println(sumFraction(f1, f2));
        System.out.println(subtractionFraction(f1,f2));
        System.out.println(divisionFraction(f1, f2));
    
    }
}
