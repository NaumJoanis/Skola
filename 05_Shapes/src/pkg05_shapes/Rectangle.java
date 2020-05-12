package pkg05_shapes;

/**
 *
 * @author Joanis Naum
 */
public class Rectangle extends Shape {
    //data
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        //return "Rectangle{" + "a=" + a + ", b=" + b + '}';
        return super.toString() + String.format(" a = %.2f b = %.2f", a, b);
    }
    
    @Override
    public double area(){
        return a*b;
    }
    
}
