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
@Table(name = "cf_tipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfTipoProducto.findAll", query = "SELECT c FROM CfTipoProducto c")})
public class CfTipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_producto_id")
    private Integer tipoProductoId;
    @Basic(optional = false)
    @Column(name = "tipo_producto_desc")
    private String tipoProductoDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProductoId")
    private List<CfProducto> cfProductoList;

    public CfTipoProducto() {
    }

    public CfTipoProducto(Integer tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public CfTipoProducto(Integer tipoProductoId, String tipoProductoDesc) {
        this.tipoProductoId = tipoProductoId;
        this.tipoProductoDesc = tipoProductoDesc;
    }

    public Integer getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(Integer tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public String getTipoProductoDesc() {
        return tipoProductoDesc;
    }

    public void setTipoProductoDesc(String tipoProductoDesc) {
        this.tipoProductoDesc = tipoProductoDesc;
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
        hash += (tipoProductoId != null ? tipoProductoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfTipoProducto)) {
            return false;
        }
        CfTipoProducto other = (CfTipoProducto) object;
        if ((this.tipoProductoId == null && other.tipoProductoId != null) || (this.tipoProductoId != null && !this.tipoProductoId.equals(other.tipoProductoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfTipoProducto[ tipoProductoId=" + tipoProductoId + " ]";
    }
    
}
