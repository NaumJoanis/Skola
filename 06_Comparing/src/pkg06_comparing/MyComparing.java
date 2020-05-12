package pkg06_comparing;

/**
 *
 * @author Joanis Naum
 */
public class MyComparing {
    
    private static void sortByNumber(Student[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1].startLater(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    public static void sort(Object [] array, ComparatorI comparator){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(comparator.bigger(array[j-1], array[j])){
                    Object temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    private static void sortByAge(Student[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1].isOlder(array[j])){
                    Student temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    private static void sort(CompareInterface[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if(array[j-1].isSmaller(array[j])){
                    CompareInterface temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    public static void print(Object[] array){
        for (Object student : array) {
            System.out.println(student);
        }
    }    
    
    
    
    public static void main(String[] args) {
        Student[] students = Datasource.loadDataAsArray();
        //test shody objektu
        System.out.println(students[0].equals(students[1]));
        
        
        //print(students);
        //System.out.println("sort by number");
        //sortByNumber(students);
        //print(students);
        //System.out.println("sort by age");
        //sortByAge(students);
        //print(students);
        //System.out.println("sort by number");
        //sort(students);
        //print(students);
    }
}
