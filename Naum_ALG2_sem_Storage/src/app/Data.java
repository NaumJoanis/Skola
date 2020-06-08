package app;

import filehandling.TextWriter;
import filehandling.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.IllegalFilenameException;

/**
 *
 * @author Joanis Naum
 */

public class Data implements StorageInterface{
    
    
    /**
     * Metoda načítá soubor s uloženými produkty.
     * 
     * @param startFilePath = Název souboru, který se bude načítat
     * @throws FileNotFoundException 
     */
    public void load(String startFilePath) throws FileNotFoundException {
        Pattern c = Pattern.compile("[a-zA-Z0-9_-]+[.][a-zA-Z0-9_-]{2,4}");
        Matcher m = c.matcher(startFilePath);
        if (m.find()) {
            System.out.println("----Soubor se úspěšně načetl----");
        } else {
            throw new IllegalFilenameException("Soubor neexistuje a nebo obsahuje nepovolené znaky (např: soubor.txt)");
        }
        File productFile = new File(startFilePath);
        try (Scanner inStart = new Scanner(productFile)) {
            while (inStart.hasNext()) {
                String name = inStart.next();
                int pcs = inStart.nextInt();
                Product p = new Product(name, pcs);
                products.add(p);
            }
        }
    }
    
    
    /**
     * Metoda ukládá hodnoty do souboru
     * @param resultFilepath = Název souboru, který se bude ukládat
     * @throws IOException 
     */
    public void saveResults(String resultFilepath) throws IOException { //ošetření výjimky vyhozením výš 
        Collections.sort(products);
        Writer w = null;
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriter();
        } else {
            throw new IllegalArgumentException("Nepodporovana pripona souboru");
        }
        w.saveResults(resultFilepath, products);
    }
    
   
    
    
}
