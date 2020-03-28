/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import javax.enterprise.context.SessionScoped;
import java.sql.Date;;


/**
 *
 * @author Jairo Gomez
 */
@ManagedBean(name="alquiler")
@SessionScoped
public class AlquilerItemsBean extends BasePageBean{
    private ArrayList<ItemRentado> rentadosDefault = new ArrayList<>(); 
    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private Cliente clienteActual;
    private long costo;
     private List<Item> disponibles;
    private List<ItemRentado> rentados;
    private List<Cliente> clientes;
    
    private long multa;


    
    public void home(){
        try{
            clientes=serviciosAlquiler.consultarClientes();   
        }catch(ExcepcionServiciosAlquiler e){
             Logger.getLogger(AlquilerItemsBean.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    public void registrarCliente(long doc,String nombre,String telefono, String direccion,String mail){
        Cliente c = new Cliente (nombre,doc,telefono,direccion,mail);
        try {
            serviciosAlquiler.registrarCliente(c);
        } catch (ExcepcionServiciosAlquiler ex) {
            Logger.getLogger(AlquilerItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarAlquiler(long docu, int iditem, int numdias){
        try {
            Item item;
            item = serviciosAlquiler.consultarItem(iditem);
            serviciosAlquiler.registrarAlquilerCliente(new Date(System.currentTimeMillis()), docu, item, numdias);
        } catch (ExcepcionServiciosAlquiler ex) {
            Logger.getLogger(AlquilerItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void consultarCostoRenta(int iditem,int numerodias){
        try {
            costo = serviciosAlquiler.consultarCostoAlquiler(iditem, numerodias);
        } catch (ExcepcionServiciosAlquiler ex) {
            costo = 0;
        }
    }
        private void consultarMulta(){
        long total=0;
        try {
            if(rentados!=null){
                
                for(ItemRentado i: rentados){
                    total+=serviciosAlquiler.consultarMultaAlquiler(i.getItem().getId(),new Date(System.currentTimeMillis()));
                }
            }
        }catch (ExcepcionServiciosAlquiler ex) {
                Logger.getLogger(AlquilerItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        multa=total;
        
    }

    public ServiciosAlquiler getServiciosAlquiler() {
        return serviciosAlquiler;
    }

    public void setServiciosAlquiler(ServiciosAlquiler serviciosAlquiler) {
        this.serviciosAlquiler = serviciosAlquiler;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public List<Item> getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(List<Item> disponibles) {
        this.disponibles = disponibles;
    }

    public List<ItemRentado> getRentados() {
        return rentados;
    }

    public void setRentados(List<ItemRentado> rentados) {
        this.rentados = rentados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public long getMulta() {
        return multa;
    }

    public void setMulta(long multa) {
        this.multa = multa;
    }
    
    
}