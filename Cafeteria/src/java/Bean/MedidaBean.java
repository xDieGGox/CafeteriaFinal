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
@ManagedBean(name = "medidaBean")
@RequestScoped
public class MedidaBean {
    private Controlador service;
    private CfMedida medida;
    
    public MedidaBean(){
        service = new Controlador();
        medida = new CfMedida(); 
    }
    
    public String insertar(){
        service.insertar(medida);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Medida Creada!"));
        return "Medida";
    }
    
    public List<CfMedida>getMedidas(){
        return service.getAllMedidas();
    }
    
    //Getters and Setters

    public CfMedida getMedida() {
        return medida;
    }

    public void setMedida(CfMedida medida) {
        this.medida = medida;
    }
    
}
