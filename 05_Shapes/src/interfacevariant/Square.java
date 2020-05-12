package interfacevariant;

import pkg05_shapes.*;

/**
 *
 * @author Joanis Naum
 */
public class Square extends Rectangle{ // IS A each square is a rectangle(nejde naopak)
    private double a;
    
    public Square(double a){
        super(a, a);
    }
    
    public static void main(String[] args) {
        Square s = new Square(4);
        System.out.println(s.area());
    }
    
}
