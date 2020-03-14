/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

/**
 *
 * @author daniel.gomez-su
 */
public class PersistenceException extends Exception {
    
    private static final String ERROR_PERSISTENCIA = "Error de persistencia";
    public PersistenceException (String message){
        super(message);
    }

    public PersistenceException(String string, Exception e) {
        super(string);
    }
   
}
