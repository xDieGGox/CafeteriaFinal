/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.persistence.*;
import Entities.*;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Controlador {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public Controlador(){
        emf = Persistence.createEntityManagerFactory("CafeteriaFinalPU");
        em = emf.createEntityManager();
    }
    
    public void insertar(Object o){
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }
    
    public void eliminar(Object o){
        em.getTransaction().begin();
        em.remove(o); 
        em.getTransaction().commit();
    }
    
    public void actualizar(Object o){
        em.getTransaction().begin();
        em.merge(o); 
        em.getTransaction().commit();
    }
    
    public CfProducto buscarProducto(int codigo){
        return em.find(CfProducto.class, codigo); 
    }
    
    public CfEmpleado buscarEmpleado(int codigo){
        return em.find(CfEmpleado.class, codigo); 
    }
    
    public CfCliente buscarCliente(int codigo){
        return em.find(CfCliente.class, codigo); 
    }
    
    public CfProveedor buscarProveedor(int codigo){
        return em.find(CfProveedor.class,codigo);
    }
    
    public CfTipoProducto buscarTipoProducto(int codigo){
        return em.find(CfTipoProducto.class, codigo); 
    }
    
    public CfMedida buscarMedida(int codigo){
        return em.find(CfMedida.class, codigo);
    }
    public CfPersona buscarPersona(int codigo){
        return em.find(CfPersona.class,codigo);
    }
    
    //LISTAS PARA EXTRAER INFORMACION
    public List<CfProducto> getAllProductos(){
        String SQL = "select p from CfProducto p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfEmpleado> getAllEmpleados(){
        String SQL = "select p from CfEmpleado p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfCliente> getAllClientes(){
        String SQL = "select p from CfCliente p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfProveedor> getAllProveedores(){
        String SQL = "select p from CfProveedor p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfTipoProducto> getAllTiposProducto(){
        String SQL = "select p from CfTipoProducto p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfMedida> getAllMedidas(){
        String SQL ="select p from CfMedida p";
        return em.createQuery(SQL).getResultList();
    }
    
    public List<CfPersona> getAllPersonas(){
        String SQL="select p from CfPersona p";
        return em.createQuery(SQL).getResultList();
    }
}
