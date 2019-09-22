/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Entities.*;
import Controller.*;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author Usuario
 */
@ManagedBean(name = "prodBean")
@RequestScoped
public class ProductoBean {
    private Controlador service;
    //private String prodDesc;//forma mediante atributos
    private CfProducto prod;//forma mediante objetos
    
    public ProductoBean(){
        service = new Controlador();
        prod = new CfProducto();
        
    }
    
    public String insertar(){
        service.insertar(prod); 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto creado!"));
        return "Producto";
    }
    
    public List<CfProducto>getProductos(){
        return service.getAllProductos();
    }
    
    
    //Getters and Setters
    public CfProducto getProd() {
        return prod;
    }

    public void setProd(CfProducto prod) {
        this.prod = prod;
    }
    
    
}
