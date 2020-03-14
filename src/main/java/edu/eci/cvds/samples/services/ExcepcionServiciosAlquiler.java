/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

/**
 *
 * @author daniel.gomez-su
 */
public class ExcepcionServiciosAlquiler extends Exception {
    
    public ExcepcionServiciosAlquiler (String message,Exception e){
        super(message);
    }    

    public ExcepcionServiciosAlquiler(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
