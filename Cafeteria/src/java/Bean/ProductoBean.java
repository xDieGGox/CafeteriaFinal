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
    
    //Para los combos
    private int codigoTipoProd;
    private int codigoMedida;
    
    public ProductoBean(){
        service = new Controlador();
        prod = new CfProducto();
        
    }
    
    public String insertar(){ 
        String msg="";
        CfTipoProducto tipProd= service.buscarTipoProducto(codigoTipoProd);
        CfProducto nuevo = service.buscarProducto(prod.getProductoId());
        CfMedida medid=service.buscarMedida(codigoMedida);
        
        if(nuevo==null){
            prod.setTipoProductoId(tipProd);
            prod.setMedidaId(medid); 
            service.insertar(prod); 
        }else{
            msg="El producto ya se encuentra registrado";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
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

    public int getCodigoTipoProd() {
        return codigoTipoProd;
    }

    public void setCodigoTipoProd(int codigoTipoProd) {
        this.codigoTipoProd = codigoTipoProd;
    }

    public int getCodigoMedida() {
        return codigoMedida;
    }

    public void setCodigoMedida(int codigoMedida) {
        this.codigoMedida = codigoMedida;
    }
    
    
}
