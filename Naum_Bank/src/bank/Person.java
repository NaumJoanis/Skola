package bank;

/**
 *
 * @author Joanis Naum
 */
public class Person extends Client {
    
    private String name;
    
    public Person(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String callName() {
        
        String ending = this.name.substring(this.name.length()-3);
        if("ova".equals(ending)){
            return "Paní " + this.name;
        } else{
            return "Pan " + this.name;
        }
    }
    
    
    
    
}
