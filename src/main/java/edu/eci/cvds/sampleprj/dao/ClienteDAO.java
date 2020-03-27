/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author daniel.gomez-su
 */
public interface ClienteDAO {
    
    public void save(Cliente c) throws PersistenceException;

    public Cliente load(int id) throws PersistenceException;
    
     public List<Cliente> consultarClientes() throws PersistenceException;
    
     public void agregarItemRentadoACliente(long id, 
            int idit, 
            Date fechainicio,
            Date fechafin)throws PersistenceException;
}
