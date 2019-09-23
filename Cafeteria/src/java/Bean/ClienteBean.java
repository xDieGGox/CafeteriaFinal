/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.*;
import Entities.*;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MATUTE19
 */
@ManagedBean(name = "clieBean")
@RequestScoped
public class ClienteBean {
    
    private Controlador service;
    private  CfCliente clie;

    private int codigoPersona;
            
    public ClienteBean() {
        service = new Controlador();
        clie = new CfCliente();
    }

    public String insertar() {
        String msg = "";
        CfCliente nuevo = service.buscarCliente(clie.getClienteId());
        CfPersona prs=service.buscarPersona(codigoPersona);
                
        if (nuevo == null) {
            clie.setPersonaId(prs);
            service.insertar(clie);
        } else {
            msg = "El cliente ya se encuentra registrado";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
        return "Cliente";
    }
    
    public List<CfCliente>getClientes(){
        return service.getAllClientes();
    }
    
   //Getters and Setters
    public CfCliente getClie() {
        return clie;
    }

    public void setClie(CfCliente clie) {
        this.clie = clie;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
    
    
}
