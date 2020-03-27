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
       
    }    

    public ExcepcionServiciosAlquiler(String string) {
        super(string); //To change body of generated methods, choose Tools | Templates.
    }
}
