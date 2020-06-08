package ui;

/**
 *
 * @author Joanis Naum
 */
import app.*;
import filehandling.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    
    /**
     * objekty pro volani potrebnych metod a praci s daty ulozenych v 
     * ArrayListu
     */
    public static Scanner sc = new Scanner(System.in);
    public static Data d = new Data();
    public static Storage s = new Storage();
    public static LocalDate localdate;
    public static DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Zadejte jméno souboru, který chcete nahrát: ");
        System.out.println("---------------------------");
        String startFile = sc.next(); //zde načítám soubor s uloženými produkty
        d.load(startFile);
        
        String menu = "Menu:"
                + "\n---------------------------"
                + "\n1 - Zobraz obsah skladu"
                + "\n2 - Přidej produkt"
                + "\n3 - Odeber počet kusů produktu"
                + "\n4 - Odstraň produkt ze seznamu"
                + "\n5 - Zobraz obsah skladu podle abecedy"
                + "\n6 - Zobraz obsah skladu podle dostupnosti"
                + "\n7 - Vyhledej produkt"
                + "\n0 - Konec programu"
                + "\n---------------------------";
        
        System.out.println(menu);
        int choice = sc.nextInt();
        while (choice > 0) {
            Menu(choice, s);
            System.out.println(menu);
            choice = sc.nextInt();
        }
        setLocalDate();
        System.out.println(localdate);
        String resultFile = "productsInStorage" + localdate + ".txt" ;
        System.out.println(resultFile);
        d.saveResults(resultFile);
        System.out.println("Data se úspěšně uložila.");
    }

    /**
     * Metoda, která obsahuje Switch a vybírá správnou metodu
     * podle našeho výběru
     * @param choice = Náš výběr
     * @param s 
     */
    public static void Menu(int choice, Storage s) throws IOException {

        switch (choice) {
            case 1:
                System.out.println("Seznam produktů: ");
                System.out.println("---------------------------");
                System.out.println(s.DisplayStorage());
                break;
            case 2:
                addProductsNumber(sc, s);
                break;
            case 3:
                removeProductsNumber(sc, s);
                break;
            case 4:
                deleteProduct(sc, s);
                break;
            case 5:
                System.out.println("Seznam produktů: ");
                System.out.println("---------------------------");
                System.out.println(s.sortByAlphabet());
                break;
            case 6:
                System.out.println("Seznam dostupných produktů: ");
                System.out.println("---------------------------");
                System.out.println(s.sortByAvailability());
                break;
            case 7:
                System.out.println("Zadej jméno hledaného výrobku:");
                System.out.println("---------------------------");
                System.out.println(productFinder(sc, s));
                System.out.println("---------------------------");
                break;
            default:
                System.out.println("Wrong choice!");
                System.out.println("---------------------------");
                break;
        }

    }

    /**
     * Metoda pro vhodný výběr metody, která bud´to přidá nový produkt nebo jen
     * přidá počet kusů k produktu, který se na seznamu už nachází
     * @param sc = Scanner
     * @param s
     * @return 
     */
    public static Storage addProductsNumber(Scanner sc, Storage s) {
        boolean isExist = false;
        System.out.println("zadej jméno produktu");
        System.out.println("---------------------------");
        String name = sc.next();
        if (s.isThere(name)) {
            System.out.println("Zadej počet kusů které chceš přidat");
            System.out.println("---------------------------");
            int pcs = sc.nextInt();
            s.addProduct(name, pcs);
        } else {
            System.out.println("Zadej počet kusů");
            System.out.println("---------------------------");
            int pcs = sc.nextInt();
            s.addNewProduct(name, pcs);
        }
        return s;
    }

    /**
     * Metoda, která načte jméno a počet kusů, které chceme odebrat
     * @param sc = Scanner
     * @param s
     * @return 
     */
    public static Storage removeProductsNumber(Scanner sc, Storage s) {
        System.out.println("Zadej jméno produktu");
        System.out.println("---------------------------");
        String name = sc.next();
        System.out.println("Zadej počet kusů které chceš odebrat");
        System.out.println("---------------------------");
        int pcs = sc.nextInt();
        s.removeProduct(name, pcs);
        return s;
    }

    /**
     * Metoda, která načte jméno produktu, který chceme odstranit
     * @param sc = Scanner
     * @param s
     * @return 
     */
    public static Storage deleteProduct(Scanner sc, Storage s) {
        System.out.println("Zadej jméno produktu který chceš smazat ze seznamu");
        System.out.println("---------------------------");
        String name = sc.next();
        s.removeProductPernamently(name);
        return s;
    }

    /**
     * Metoda, která načte jméno produktu, který chceme vyhledat
     * @param sc = Scanner
     * @param s
     * @return 
     */
    public static String productFinder(Scanner sc, Storage s) {
        String name = sc.next();
        return s.findProduct(name);
    }

    /**
     * Metoda, která nastaví dnešní datum
     */
    public static void setLocalDate(){
        localdate = LocalDate.parse(LocalDate.now().toString(), date);
    }
}
