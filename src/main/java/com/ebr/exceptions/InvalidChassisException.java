/*
 * Exception - Invalid chassis number
 */
package com.ebr.exceptions;

/**
 *
 * @author Eduardo
 */
public class InvalidChassisException extends Exception{
    private static final long serialVersionUID = -123456792L;
    public InvalidChassisException(String chassi){
        super(String.format("Este chassi é inválido [%s]", chassi));
    }
}
