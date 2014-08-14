/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Fein
 */
public class BankException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int k =0; k < 100000; k++) {
            final Random rnd = new Random(k);
            ITransactionManager m = new TransactionManager();
            final AtomicBoolean zedDead = new AtomicBoolean(false);
            IAccount[] accounts = {new BankAccount(), 
                new BankAccount(), 
                new BankAccount()};
            int[] money =  {-1,2,5};
            boolean ok = m.transfer(accounts, money);
            if (ok) {
                for (int i=0; i< accounts.length; i++) {
                    if (accounts[i].getTotalChange() != money[i]) {
                        throw new AssertionError("FAIL commit: "+Arrays.toString(money));
                    }
                }
                System.out.println("OK");
            } else {
                
            }
        }
    }
}
