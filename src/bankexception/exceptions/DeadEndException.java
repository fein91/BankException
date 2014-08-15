/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankexception.exceptions;

/**
 *
 * @author otatarik
 */
public class DeadEndException extends RuntimeException {

    public DeadEndException(String message) {
        super(message);
    }

    public DeadEndException() {
    }

}
