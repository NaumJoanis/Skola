package pkg05_shapes;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Joanis Naum
 */
public class ShapesApp {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList();
        int option = 1;
        while(option != 0){
        DisplayMenu();
        option = getOption(sc);
        
        switch(option){
            case 0:
                break;
            case 1:
                addSquare(sc, shapes);
                break;
            case 2:
               addRectangle(sc, shapes);
               break;
            case 3:
                addCircle(sc, shapes);
                break;
            case 4:
                System.out.println(shapes);
                break;
            case 5:
                computeArea(shapes);
                break;
            case 6:
                clearObjects(shapes);
                break;
            default:
                System.out.println("Chybná volba.");
                break;
        }
        }
    }
    
    public static void DisplayMenu(){
        System.out.println("0. Konec programu");
        System.out.println("1. Přidej čtverec");
        System.out.println("2. Přidej obdélník");
        System.out.println("3. Přidej kruh");
        System.out.println("4. Vypsat všechny obrazce");
        System.out.println("5. Celková plocha všech obrazců");
        System.out.println("6. Vymazat všechny obrazce");
        
    }
    
    public static int getOption(Scanner sc){
        int option = sc.nextInt();
        return option;
    }
    
    public static void addSquare(Scanner sc, ArrayList<Shape> shapes){
        System.out.println("Zadejte rozměr strany a");
        int a = sc.nextInt();
        Square s = new Square(a);
        shapes.add(s);
    }
    
    public static void addRectangle(Scanner sc , ArrayList<Shape> shapes){
        System.out.println("Zadejte rozměr strany a, b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Rectangle r = new Rectangle(a,b);
        shapes.add(r);
    }
    
    public static void addCircle(Scanner sc , ArrayList<Shape> shapes){
        System.out.println("1. zadání poloměru");
        System.out.println("2. zadání průměru");
        int option = sc.nextInt();
        switch(option){
            case 1:
                System.out.println("zadejte poloměr r");
                int r = sc.nextInt();
                Circle c = new Circle(r);
                shapes.add(c);
                break;
            case 2:
                System.out.println("zadejte průměr d");
                int d = sc.nextInt();
                Circle c1 = new Circle(d);
                shapes.add(c1);
                break;
            default:
                System.out.println("Chybná volba.");
                break;
        }
        
    }
    
    public static void computeArea(ArrayList<Shape> shapes){
        double area = 0;
        for(Shape s: shapes){
            area += s.area(); //polymorfizmus
        }
        System.out.format("Celková plocha všech obrazců je : %.2f.%n", area);
        System.out.println("");
    }
    private static void clearObjects(ArrayList<Shape> shapes) {
        shapes.clear();
        System.out.println("Všechny geometrické útvary byly vymazány.");
    }
}
