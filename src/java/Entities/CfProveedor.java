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
@Table(name = "cf_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfProveedor.findAll", query = "SELECT c FROM CfProveedor c")})
public class CfProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proveedor_id")
    private Integer proveedorId;
    @Basic(optional = false)
    @Column(name = "proveedor_desc")
    private String proveedorDesc;
    @Basic(optional = false)
    @Column(name = "proveedor_ruc")
    private String proveedorRuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedorId")
    private List<CfCompra> cfCompraList;

    public CfProveedor() {
    }

    public CfProveedor(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public CfProveedor(Integer proveedorId, String proveedorDesc, String proveedorRuc) {
        this.proveedorId = proveedorId;
        this.proveedorDesc = proveedorDesc;
        this.proveedorRuc = proveedorRuc;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getProveedorDesc() {
        return proveedorDesc;
    }

    public void setProveedorDesc(String proveedorDesc) {
        this.proveedorDesc = proveedorDesc;
    }

    public String getProveedorRuc() {
        return proveedorRuc;
    }

    public void setProveedorRuc(String proveedorRuc) {
        this.proveedorRuc = proveedorRuc;
    }

    @XmlTransient
    public List<CfCompra> getCfCompraList() {
        return cfCompraList;
    }

    public void setCfCompraList(List<CfCompra> cfCompraList) {
        this.cfCompraList = cfCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorId != null ? proveedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfProveedor)) {
            return false;
        }
        CfProveedor other = (CfProveedor) object;
        if ((this.proveedorId == null && other.proveedorId != null) || (this.proveedorId != null && !this.proveedorId.equals(other.proveedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfProveedor[ proveedorId=" + proveedorId + " ]";
    }
    
}
