/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Controller.Controlador;
import Entities.CfPersona;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MATUTE19
 */
@ManagedBean(name="personaBean")
@RequestScoped
public class PersonaBean {

    private Controlador service;
    private CfPersona persona;
    
    public PersonaBean() {
        service=new Controlador();
        persona=new CfPersona();
    }
    
    public String insertar(){
        String msg="";
        CfPersona nuevo=service.buscarPersona(persona.getPersonaId());
        
        if(nuevo==null){
            service.insertar(persona);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Persona Creada!"));
        }else{
            msg="Esta persona se encuentra registrada";
        }
        return "Persona";
    }

    public List<CfPersona>getPersonas(){
        return service.getAllPersonas();
    }

    public CfPersona getPersona() {
        return persona;
    }

    public void setPersona(CfPersona persona) {
        this.persona = persona;
    }
     
    
}
