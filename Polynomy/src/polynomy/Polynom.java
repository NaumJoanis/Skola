package polynomy;

import java.util.Arrays;

public class Polynom {
    //5x3 + 2x2 + 3

    // 0 1 2 3 //indexy reprezentují exponenty
    // 3 0 2 5 //hodnoty reprezentují koeficienty
    //data
    private double[] coef;

    //constructor
    /*5 2 0 3 
    [5, 2, 0, 3]
    3 0 2 5 
    [3, 0, 2, 5]
    5x3 + 2x2 + 3*/
    private Polynom(double[] coef) { //defenzivni kopie
        double[] coefTemp = new double[coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }

    //tovarni factory metoda
    public static Polynom getInstance(double... coef) { //[3, 0, 2, 5]
        return new Polynom(coef);
    }

    //getinstanereverted
    public static Polynom getInstanceReverted(double[] coef) { //[5, 2, 0, 3]
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coef.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    //metody
    public int getDegree() {
        return coef.length - 1;
    }

    public double getCoefAt(int exponent) {
        return coef[exponent];
    }

    public double[] getCoef() {
        return Arrays.copyOf(coef, coef.length); //defenzivni kopie
    }

    public Polynom derivate() {
        double[] derivation = new double[coef.length - 1];
        for (int i = 0; i < derivation.length; i++) {
            derivation[i] = coef[i] * (coef.length - 1 - i);
        }
        return new Polynom(derivation);
    }

    //todo
    public double computeValue(double x) {
        //5x3 + 2x2 + 0x + 3

        double sum = 0;
        int n = getDegree();
        for (int i = 0; i < n; i++) {
            sum = (sum + coef[i]) * x;
        }
        sum += coef[coef.length - 1];
        return sum;
    }

    /*
        
    }
    //todo bonus
    public double integrate(double a, double b){
        
    }*/

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < coef.length; i++) {
            if (coef[i] != 0) {
                if (i == 0) {
                    output += Math.abs(coef[i]) + "x^" + (getDegree() - i);
                } else {
                    if((getDegree() - i) > 1){
                    if (coef[i] > 0) {
                        output += " + " + Math.abs(coef[i]) + "x^" + (getDegree() - i);
                    } else if (coef[i] < 0) {
                        output += " - " + Math.abs(coef[i]) + "x^" + (getDegree() - i);
                    }
                    }else if((getDegree() - i) == 1){
                        if (coef[i] > 0) {
                        output += " + " + Math.abs(coef[i]) + "x";
                    } else if (coef[i] < 0) {
                        output += " - " + Math.abs(coef[i]) + "x";
                    }
                    }else{
                        if (coef[i] > 0) {
                        output += " + " + Math.abs(coef[i]);
                    } else if (coef[i] < 0) {
                        output += " - " + Math.abs(coef[i]);
                    }
                    }
                }
            }
 
        }
        return output;
    }

    /*@Override
    public String toString() {
        return Arrays.toString(coef);
    }*/
    public static void main(String[] args) {
        double[] coef = {5, 2, 0, 3};
        Polynom p = Polynom.getInstance(coef);
        System.out.println(p);
        System.out.println(p.computeValue(3));
        System.out.println(p.derivate());

    }
}
