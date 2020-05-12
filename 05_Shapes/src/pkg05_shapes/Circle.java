package pkg05_shapes;

/**
 *
 * @author Joanis Naum
 */
public class Circle extends Shape {

    //data
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    //TODO udelat pomoci tovarni metody
    public static Circle getInstaceD(double d) {
        return new Circle(d/2);
    }
    
    public static Circle getInstaceR(double r) {
        return new Circle(r);
    }
    
    //getter
    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        //return "Circle{" + "r=" + r + '}';
        return super.toString() + String.format(" r = %.2f", r);
    }
    
    @Override
    public double area() {
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        Circle c = new Circle(2);
        System.out.println(c);
        System.out.println(c.area());
        System.out.println(c.getShapeName());
    }
    
}
