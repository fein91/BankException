/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

/**
 *
 * @author Fein
 */
public interface ITransactionManager {
    public boolean transfer(IAccount[] accounts, int[] money);
}
