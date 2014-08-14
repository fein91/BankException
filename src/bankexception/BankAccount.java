/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception;

/**
 *
 * @author Fein
 */
public class BankAccount implements IAccount{

    @Override
    public int getTotalChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void change(int delta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
