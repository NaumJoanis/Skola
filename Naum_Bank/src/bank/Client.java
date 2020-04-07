
package bank;
import java.util.ArrayList;
/**
 *
 * @author home
 */
public abstract class Client {
    
    private String name;
    private ArrayList<Account> accounts = new ArrayList();

    public Client(String name) {
        this.name = name;
    }

    

    public void newAccount(double value) {
        this.accounts.add(new Account(value));
    }

    
    public double getTotalBalance() {
        double sum = 0;
        for(Account account : accounts) {
            sum += account.getBalance();
        }
        return sum;
    }
    
    public abstract String callName();
}
