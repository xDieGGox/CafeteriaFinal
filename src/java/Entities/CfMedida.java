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
@Table(name = "cf_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfMedida.findAll", query = "SELECT c FROM CfMedida c")})
public class CfMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medida_id")
    private Integer medidaId;
    @Basic(optional = false)
    @Column(name = "medida_sigla")
    private int medidaSigla;
    @Basic(optional = false)
    @Column(name = "medida_descripcion")
    private int medidaDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medidaId")
    private List<CfProducto> cfProductoList;

    public CfMedida() {
    }

    public CfMedida(Integer medidaId) {
        this.medidaId = medidaId;
    }

    public CfMedida(Integer medidaId, int medidaSigla, int medidaDescripcion) {
        this.medidaId = medidaId;
        this.medidaSigla = medidaSigla;
        this.medidaDescripcion = medidaDescripcion;
    }

    public Integer getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(Integer medidaId) {
        this.medidaId = medidaId;
    }

    public int getMedidaSigla() {
        return medidaSigla;
    }

    public void setMedidaSigla(int medidaSigla) {
        this.medidaSigla = medidaSigla;
    }

    public int getMedidaDescripcion() {
        return medidaDescripcion;
    }

    public void setMedidaDescripcion(int medidaDescripcion) {
        this.medidaDescripcion = medidaDescripcion;
    }

    @XmlTransient
    public List<CfProducto> getCfProductoList() {
        return cfProductoList;
    }

    public void setCfProductoList(List<CfProducto> cfProductoList) {
        this.cfProductoList = cfProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medidaId != null ? medidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfMedida)) {
            return false;
        }
        CfMedida other = (CfMedida) object;
        if ((this.medidaId == null && other.medidaId != null) || (this.medidaId != null && !this.medidaId.equals(other.medidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfMedida[ medidaId=" + medidaId + " ]";
    }
    
}
