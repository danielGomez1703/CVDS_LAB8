/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds;

/**
 *
 * @author Jairo Gomez
 */
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;
    Cliente cliente=new Cliente("Oscar Alba", 1026585664, "6788952", "KRA 109#34-C30", "oscar@hotmail.com", false,null);

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for(int i = 0; i <3; i ++) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente((long)i);
            }catch(ExcepcionServiciosAlquiler | IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }
    @Test
    public void deberiaConsultarCliente(){
        try {
            serviciosAlquiler.consultarCliente(1026585664);
            Assert.assertTrue(true);
        } catch (ExcepcionServiciosAlquiler ex) {
            Assert.fail();
        }
    }
    
    @Test
    public void ClienteRegistrado(){
        
        boolean r=false;
        try{
            serviciosAlquiler.registrarCliente(cliente);
        }catch(ExcepcionServiciosAlquiler e){
            r=true;
        }
        Assert.assertTrue(r);
    }
    
    @Test
    public void pruebaVetarCliente(){
        
        boolean r=true;
        try{
            serviciosAlquiler.vetarCliente(1026585664,true);
        }catch(ExcepcionServiciosAlquiler e){
            r=false;
        }
        Assert.assertTrue(r);
    }
     @Test
    public void pruebaNoVetarCliente(){
        
        boolean r=true;
        try{
            serviciosAlquiler.vetarCliente(1026585663,true);
        }catch(ExcepcionServiciosAlquiler e){
            r=false;
        }
        Assert.assertTrue(r);
    }
    
    @Test
    public void testConsultarItem(){
        try {
            serviciosAlquiler.consultarItem(6);
            Assert.assertTrue(true);
        } catch (ExcepcionServiciosAlquiler ex) {
            Assert.fail();
        }
    }
    @Test
    public void testRegistrarItem(){
        TipoItem ti1=new TipoItem(1,"Video");
        Item i1=new Item(ti1, 1, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");
        try {
            serviciosAlquiler.registrarItem(i1);
            Assert.assertTrue(true);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.fail();
        }
    }
    
    @Test
     public void testactualizarTarifaItem(){
        try {
            serviciosAlquiler.actualizarTarifaItem(4, 2500);
            Assert.assertTrue(true);
        } catch (ExcepcionServiciosAlquiler e) {
             Assert.assertTrue(false);
        }
    }
     @Test
     public void testregistrarAlquilerCliente(){

        TipoItem ti1=new TipoItem(1,"Video");
        Item i1=new Item(ti1, 4, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");

        try{
            serviciosAlquiler.registrarAlquilerCliente(java.sql.Date.valueOf("2007-09-08"),1026585664,i1,5);
            Assert.assertTrue(true);
        }catch (ExcepcionServiciosAlquiler e) {
            Assert.assertTrue(false);
        }
    }

}

