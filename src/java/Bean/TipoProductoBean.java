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
@ManagedBean(name = "tipProdBean")
@RequestScoped
public class TipoProductoBean {
    private Controlador service;
    private CfTipoProducto tipprod;
    
    public TipoProductoBean(){
        service = new Controlador();
        tipprod = new CfTipoProducto();
    }
    
    public String insertar(){
        service.insertar(tipprod);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de Producto Creado"));
        return "TipoProducto";
    }
    
    public List<CfTipoProducto>getTiposProducto(){
        return service.getAllTiposProducto();
    }
    
    //Getters and Setters

    public CfTipoProducto getTipprod() {
        return tipprod;
    }

    public void setTipprod(CfTipoProducto tipprod) {
        this.tipprod = tipprod;
    }
    
    
}
