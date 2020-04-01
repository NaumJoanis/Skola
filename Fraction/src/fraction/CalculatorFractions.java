package fraction;

public class CalculatorFractions {

    public static Fraction multiplyFraction(Fraction a, Fraction b) {
        int[] m = new int[2];
        m[0] = a.getNumerator() * b.getNumerator();
        m[1] = a.getDenominator() * b.getDenominator();
        
        int i = m[0];
        int j = m[1];
        int temp = 0;
        int del;

        if (i == j) {
            del = i;
        }

        while (j > 0) {
            temp = j;
            j = i % j;
            i = temp;
        }
        del = i;
        m[0] /= del;
        m[1] /= del;
        
        return Fraction.getInstance(m);
    }

    public static Fraction sumFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();

        int i = sum[0];
        int j = sum[1];
        int temp = 0;
        int del;

        if (i == j) {
            del = i;
        }

        while (j > 0) {
            temp = j;
            j = i % j;
            i = temp;
        }
        del = i;
        sum[0] /= del;
        sum[1] /= del;

        return Fraction.getInstance(sum);
    }
    
    public static Fraction subtractionFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();

        int i = sum[0];
        int j = sum[1];
        int temp = 0;
        int del;

        if (i == j) {
            del = i;
        }

        while (j > 0) {
            temp = j;
            j = i % j;
            i = temp;
        }
        del = i;
        sum[0] /= del;
        sum[1] /= del;

        return Fraction.getInstance(sum);
    }
    public static Fraction divisionFraction(Fraction a, Fraction b) {
        int[] sum = new int[2];
        sum[1] = a.getDenominator() * b.getDenominator();
        sum[0] = a.getNumerator() * b.getNumerator();

        int i = sum[0];
        int j = sum[1];
        int temp = 0;
        int del;

        if (i == j) {
            del = i;
        }

        while (j > 0) {
            temp = j;
            j = i % j;
            i = temp;
        }
        del = i;
        sum[0] /= del;
        sum[1] /= del;

        return Fraction.getInstance(sum);
    }

    public static void main(String[] args) {

        int[] frac1 = {3, 2};
        Fraction f1 = Fraction.getInstance(frac1);
        System.out.println("Citatel = " + f1.getNumerator());
        System.out.println("Jmenovatel = " + f1.getDenominator());
        System.out.println(f1);
        System.out.println("Nejvetsi spol. delitel je " + f1.greatestCommonDivisor());

        int[] frac2 = {2, 3};
        Fraction f2 = Fraction.getInstance(frac2);
        System.out.println(f2);
        System.out.println(multiplyFraction(f1, f2));
        System.out.println(sumFraction(f1, f2));
        System.out.println(subtractionFraction(f1,f2));
        System.out.println(divisionFraction(f1, f2));
        /*Fraction multiply = multiplyFraction(f1, f2);
        System.out.println(multiply);*/
    }
}
