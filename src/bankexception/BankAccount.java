/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

import bankexception.exceptions.DeadEndException;
import bankexception.exceptions.TryAgainException;
import java.util.Random;

/**
 *
 * @author Fein
 */
public class BankAccount implements IAccount {

    private int money;
    private final int accountId;
    private int change = 0;
    private static int counterRetry = 0;

    public BankAccount(int money, int accountId) {
        this.money = money;
        this.accountId = accountId;
    }

    @Override
    public int getTotalChange() {
        return change;
    }

    @Override
    public void change(int delta) throws DeadEndException, TryAgainException {
        generateException();
        changeWithoutException(delta);
    }

    public void changeWithoutException(int delta) {
        money += delta;
        System.out.println("Successful money amount change for account: " + accountId + ". New sum: " + money + ". Delta: " + delta);
        change += delta;
        counterRetry = 0;
    }

    private void generateException() throws DeadEndException, TryAgainException {
        int bound = 100;
        Random randomizer = new Random();
        int random = randomizer.nextInt(bound);

        if (random > 30 && random < 50) {
            counterRetry++;
            throw new TryAgainException("TryAgainException occured while processing account: " + accountId
                    + ". Count retry: " + counterRetry + ". Money: " + money);
        }

        if (random > 50 && random < 60) {
            counterRetry++;
            throw new DeadEndException("DeadEndException occured while processing account: " + accountId
                    + ". Money: " + money);
        }
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "BankAccount" + accountId + "{" + "money=" + money + ", change=" + change + '}';
    }

}
