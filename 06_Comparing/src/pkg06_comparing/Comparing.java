package pkg06_comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Joanis Naum
 */
public class Comparing {
    
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        print(students);
        System.out.println("sort by number");
        Arrays.sort(students); //student musi byt typovo kompatibilny s
        print(students);
        List<Student> students1 = Datasource.loadDataAsList();
        print(students1);
        System.out.println("sort by number");
        Collections.sort(students1);
        print(students1);
    }
    
    public static void print(Object[] array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
    
    public static void print(List array){
        for (Object o : array) {
            System.out.println(o);
        }
    }
}
