/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

import bankexception.exceptions.DeadEndException;
import bankexception.exceptions.TryAgainException;

/**
 *
 * @author Fein
 */
public interface IAccount {

    public int getTotalChange();

    public void change(int delta) throws DeadEndException, TryAgainException;

    public void changeWithoutException(int delta);

    public int getAccountId();
}
