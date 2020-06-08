package app;

import utils.IllegalFilenameException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joanis Naum
 */

public class Storage implements StorageInterface{
    
    /**
     * Metoda přidává počet kusů produktu.
     * @param name = jméno produktu
     * @param pcs = počet kusů
     */
    public void addProduct(String name, int pcs) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.Add(pcs);
            }
        }
        System.out.println("Bylo přidáno " + pcs + " ks " + name);
    }
    
    /**
     * Metoda odebírá počet kusů prodktu.
     * @param name = jméno produktu
     * @param pcs = počet kusů 
     */
    public void removeProduct(String name, int pcs) {       
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.Remove(pcs);
            }
        }
        System.out.println("Bylo odebráno " + pcs + " ks " + name);
    }
    
    /**
     * Metoda na přidání nového produktu do seznamu
     * @param name = jméno produktu
     * @param pcs = počet kusů 
     */
    public void addNewProduct(String name, int pcs) {
        Product p = new Product(name, pcs);
        products.add(p);
        System.out.println("Byl přidán nový produkt do seznamu");
    }
    
    /**
     * Metoda na ověření zda-li seznam produktů neobsahuje zadané jméno.
     * @param name = jméno produktu
     * @return 
     */
    public boolean isThere(String name) {
        boolean isExist = false;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                isExist = true;
                return isExist;
            }
        }
        return isExist;
    }
    
    /**
     * Metoda, která odstraní produkt ze seznamu.
     * @param name = jméno produktu
     * @return 
     */
    public String removeProductPernamently(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                return "Produkt" + name + "byl smazán";
            }
        }
        return "Produkt" + name + "Nebyl nalezen";
    }
    
    /**
     * Metoda, která hledá v seznamu zadaný produkt.
     * @param name = jméno produktu
     * @return 
     */
    public String findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return "Na skladě se nachází " + product.getPieces() + " kusů "
                        + product.getName();
            }
        }
        return "Hledaný výrobek není na skladě";
    }
    
    /**
     * Metoda, která nám zobrazí celý seznam.
     * (obsahuje i produkty, které mají 0 kusů)
     * @return 
     */
    public String DisplayStorage() {
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Product product : products) {
            sb.append(String.format("%-2d. %s%n", n, product));
            n++;
        }
        return sb.toString();
    }
    
    /**
     * Metoda, která nám zobrazí celý seznam seřazený podle abecedy.
     * (obsahuje i produkty, které mají 0 kusů)
     * @return 
     */
    public String sortByAlphabet() {
        Collections.sort(products);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Product product : products) {
            sb.append(String.format("%-2d. %s%n", n, product));
            n++;
        }
        return sb.toString();
    }
    
    /**
     * Metoda, která nám zobrazí seznam dostupných produktů na skladě.
     * @return 
     */
    public String sortByAvailability() {
        Collections.sort(products);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Product product : products) {
            char c = product.toString().charAt(product.toString().length() - 1);
            int a = Character.getNumericValue(c);
            if (a > 0) {
                sb.append(String.format("%-2d. %s%n", n, product));
                n++;
            }
        }
        return sb.toString();
    }
    
    

    /*public static void main(String[] args) throws FileNotFoundException {
        Storage s = new Storage();
        String startFile = sc.next();
        s.load(startFile);
        System.out.println(s.DisplayStorage());
        s.addProduct("Samsung", 2);
        s.addNewProduct("prdel", 1);
        s.removeProductPernamently("BenQ");
        System.out.println(s.DisplayStorage());
        System.out.println(s.sortByAlphabet());
        System.out.println(s.sortByAvailability());
        System.out.println(s.findProduct("BenQ"));
    }*/
}
