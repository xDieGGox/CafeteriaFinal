/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cf_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfPersona.findAll", query = "SELECT c FROM CfPersona c")})
public class CfPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id")
    private Integer personaId;
    @Basic(optional = false)
    @Column(name = "persona_cedula")
    private String personaCedula;
    @Basic(optional = false)
    @Column(name = "persona_nombre")
    private String personaNombre;
    @Basic(optional = false)
    @Column(name = "persona_apellido")
    private String personaApellido;
    @Basic(optional = false)
    @Column(name = "persona_direccion")
    private String personaDireccion;
    @Basic(optional = false)
    @Column(name = "persona_telefono")
    private String personaTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<CfEmpleado> cfEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaId")
    private List<CfCliente> cfClienteList;

    public CfPersona() {
    }

    public CfPersona(Integer personaId) {
        this.personaId = personaId;
    }

    public CfPersona(Integer personaId, String personaCedula, String personaNombre, String personaApellido, String personaDireccion, String personaTelefono) {
        this.personaId = personaId;
        this.personaCedula = personaCedula;
        this.personaNombre = personaNombre;
        this.personaApellido = personaApellido;
        this.personaDireccion = personaDireccion;
        this.personaTelefono = personaTelefono;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getPersonaCedula() {
        return personaCedula;
    }

    public void setPersonaCedula(String personaCedula) {
        this.personaCedula = personaCedula;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getPersonaDireccion() {
        return personaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        this.personaDireccion = personaDireccion;
    }

    public String getPersonaTelefono() {
        return personaTelefono;
    }

    public void setPersonaTelefono(String personaTelefono) {
        this.personaTelefono = personaTelefono;
    }

    @XmlTransient
    public List<CfEmpleado> getCfEmpleadoList() {
        return cfEmpleadoList;
    }

    public void setCfEmpleadoList(List<CfEmpleado> cfEmpleadoList) {
        this.cfEmpleadoList = cfEmpleadoList;
    }

    @XmlTransient
    public List<CfCliente> getCfClienteList() {
        return cfClienteList;
    }

    public void setCfClienteList(List<CfCliente> cfClienteList) {
        this.cfClienteList = cfClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfPersona)) {
            return false;
        }
        CfPersona other = (CfPersona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfPersona[ personaId=" + personaId + " ]";
    }
    
}
