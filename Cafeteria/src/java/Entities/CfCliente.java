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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cf_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfCliente.findAll", query = "SELECT c FROM CfCliente c")})
public class CfCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private Integer clienteId;
    @Basic(optional = false)
    @Column(name = "cliente_descuento")
    private int clienteDescuento;
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    @ManyToOne(optional = false)
    private CfPersona personaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<CfFactura> cfFacturaList;

    public CfCliente() {
    }

    public CfCliente(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public CfCliente(Integer clienteId, int clienteDescuento) {
        this.clienteId = clienteId;
        this.clienteDescuento = clienteDescuento;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public int getClienteDescuento() {
        return clienteDescuento;
    }

    public void setClienteDescuento(int clienteDescuento) {
        this.clienteDescuento = clienteDescuento;
    }

    public CfPersona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(CfPersona personaId) {
        this.personaId = personaId;
    }

    @XmlTransient
    public List<CfFactura> getCfFacturaList() {
        return cfFacturaList;
    }

    public void setCfFacturaList(List<CfFactura> cfFacturaList) {
        this.cfFacturaList = cfFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfCliente)) {
            return false;
        }
        CfCliente other = (CfCliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfCliente[ clienteId=" + clienteId + " ]";
    }
    
}
