
package bank;

/**
 *
 * @author Joanis Naum
 */
public class Account {
    
    private static double balance = 0;

    public Account() {
    }

    public Account(double value) {
        if(value <=0 ){
            throw new IllegalArgumentException("zadaná částka musí být větší než 0");
        }
        this.balance += value;
    }
    
    public void Deposit(double value) {
        if(value <=0 ){
            throw new IllegalArgumentException("zadaná částka musí být větší než 0");
        }
        this.balance += value;
    }
    
    public void withdraw(double value) {
        if(value <=0 ){
            throw new IllegalArgumentException("zadaná částka musí být větší než 0");
        }
        this.balance -= value;
    }

    public static double getBalance() {
        return balance;
    }
    
    

    @Override
    public String toString() {
        return "Zůstatek je " + balance;
    }
    
    
    
}
