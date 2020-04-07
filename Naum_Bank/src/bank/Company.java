package bank;
/**
 *
 * @author Joanis Naum
 */
public class Company extends Client {

    private String name;
    
    public Company(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String callName() {
        return "Firma " + this.name;
    }
}
