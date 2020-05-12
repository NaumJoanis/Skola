package pkg06_comparing;

/**
 *
 * @author Joanis Naum
 */
public class ComparatorI {
    public boolean bigger(Object o1, Object o2){
        ((Student)o1).getNumber() - ((Student)o2).getNumber()
    }
}
