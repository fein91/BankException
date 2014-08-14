/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

/**
 *
 * @author Fein
 */
public class TransactionManager implements ITransactionManager{

    @Override
    public boolean transfer(IAccount[] accounts, int[] money) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
