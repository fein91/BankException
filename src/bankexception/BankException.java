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

    public static void checkTransfer(IAccount[] accounts, int[] money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getTotalChange() != money[i]) {
                System.out.println("******************");
                System.out.println("SHIT, commit failed with account: " + accounts[i].getAccountId());
                System.out.println("******************");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        for (int k =0; k < 100000; k++) {
//            final Random rnd = new Random(k);
//            ITransactionManager m = new TransactionManager();
//            final AtomicBoolean zedDead = new AtomicBoolean(false);
//            IAccount[] accounts = {new BankAccount(5), 
//                new BankAccount(4), 
//                new BankAccount(3)};
//            int[] money =  {-1,2,5};
//            boolean ok = m.transfer(accounts, money);
//            if (ok) {
//                for (int i=0; i< accounts.length; i++) {
//                    if (accounts[i].getTotalChange() != money[i]) {
//                        throw new AssertionError("FAIL commit: "+Arrays.toString(money));
//                    }
//                }
//                System.out.println("OK");
//            } else {
//                
//            }
//        }
        IAccount[] accounts = {new BankAccount(5, 111),
            new BankAccount(13, 112),
            new BankAccount(9, 113),
            new BankAccount(20, 114),
            new BankAccount(0, 115),
            new BankAccount(16, 116),};
        int[] money = {-3, 12, -9, -13, 7, -2};
        System.out.println(Arrays.toString(accounts));
        TransactionManager m = new TransactionManager();
        m.transfer(accounts, money);
       // checkTransfer(accounts, money);
        System.out.println(Arrays.toString(accounts));

    }
}
