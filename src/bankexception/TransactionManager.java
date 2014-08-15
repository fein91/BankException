/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

import bankexception.exceptions.DeadEndException;
import bankexception.exceptions.TryAgainException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fein
 */
public class TransactionManager implements ITransactionManager {

    @Override
    public boolean transfer(IAccount[] accounts, int[] money) {
        boolean result = false;
        boolean again = true;
        IAccount[] rollbackAccounts = new BankAccount[accounts.length];

        try {
            for (int i = 0; i < accounts.length; i++) {
                while (again) {
                    try {
                        accounts[i].change(money[i]);
                    } catch (TryAgainException ex) {
                        ex.printStackTrace();
                        continue;
                    } catch (DeadEndException ex) {
                        ex.printStackTrace();
                        rollbackAccounts = Arrays.copyOfRange(accounts, 0, i);
                        throw ex;
                    }
                    break;
                }
            }
        } catch (DeadEndException ex) {
            if (rollbackAccounts != null) {
                for (int i = 0; i < rollbackAccounts.length; i++) {
                    rollbackAccounts[i].changeWithoutException(-money[i]);
                }
            }
        }

        return result;
    }

}
