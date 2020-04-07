package polynomy;

/**
 * Libraery knihovni trida
 *
 * @author joanis
 */
public class Polynomy {

    private Polynomy() {

    }

    public static Polynom sum(Polynom a, Polynom b) { //nemusime delat defenzivni kopii protoze polynom je immutable
        /*    5x3 + 2x2 + 0 + 3
                    4x2 + x + 2 
              5x3 + 6x2 + x + 5 */

        Polynom max = a.getDegree() > b.getDegree() ? a : b;
        Polynom min = a.getDegree() <= b.getDegree() ? a : b;

        double[] sum = new double[max.getDegree() + 1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = max.getCoefAt(i);
        }
        for (int i = 0; i < min.getDegree() + 1; i++) {
            sum[i] = sum[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sum);
    }

    //TODO (inspirováno spolužáky)
    public static Polynom multiply(Polynom a, Polynom b) {
        double[] multiply = new double[a.getDegree() + b.getDegree() + 1];

        for (int i = 0; i < a.getDegree() + 1; i++) {
            for (int j = 0; j < b.getDegree() + 1; j++) {
                multiply[i + j] += a.getCoefAt(i) * b.getCoefAt(j);
            }
        }

        return Polynom.getInstance(multiply);
    }

    public static void main(String[] args) {
        double[] polynom1 = {3, 0, 2, 5};
        double[] polynom2 = {2, 1, 4};

        Polynom p1 = Polynom.getInstanceReverted(polynom1);
        Polynom p2 = Polynom.getInstanceReverted(polynom2);
        System.out.println(sum(p1, p2));
        System.out.println(multiply(p1,p2));
    }

}
