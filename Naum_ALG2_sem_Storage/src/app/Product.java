package app;

import java.util.Comparator;

/**
 *Třída pro vytvoření objektu o produktu.
 * 
 * @author Joanis Naum
 */


public class Product implements Comparable<Product> {
    
    private String name;
    private int pcs; //number of pieces

    public Product(String name, int pcs) {
        this.name = name;
        this.pcs = pcs;
    }
    
    public void Add(int pcs){
        this.pcs += pcs;
    }
    
    public void Remove(int pcs){
        this.pcs -= pcs;
    }
    

    public String getName() {
        return name;
    }
    
    public int getPieces() {
        return pcs;
    }

    
    /**
     * Metoda, která porovnává podle abecedy počáteční písmeno produktu.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Product o){
        return name.toLowerCase().compareTo(o.name.toLowerCase());
    }
    
    @Override
    public String toString() {
        return name + " ks: " + pcs;
    }

    
    /*public static void main(String[] args) {
        Product c = new Product("Kolo", 5);
        c.setNewUpdate();
        System.out.println(c);
    }*/
    
}
