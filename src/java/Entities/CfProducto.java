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
@Table(name = "cf_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfProducto.findAll", query = "SELECT c FROM CfProducto c")})
public class CfProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_id")
    private Integer productoId;
    @Basic(optional = false)
    @Column(name = "producto_desc")
    private String productoDesc;
    @Basic(optional = false)
    @Column(name = "producto_costo")
    private double productoCosto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<CfCompra> cfCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<CfDetalle> cfDetalleList;
    @JoinColumn(name = "tipo_producto_id", referencedColumnName = "tipo_producto_id")
    @ManyToOne(optional = false)
    private CfTipoProducto tipoProductoId;
    @JoinColumn(name = "medida_id", referencedColumnName = "medida_id")
    @ManyToOne(optional = false)
    private CfMedida medidaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<CfCompraDetalle> cfCompraDetalleList;

    public CfProducto() {
    }

    public CfProducto(Integer productoId) {
        this.productoId = productoId;
    }

    public CfProducto(Integer productoId, String productoDesc, double productoCosto) {
        this.productoId = productoId;
        this.productoDesc = productoDesc;
        this.productoCosto = productoCosto;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getProductoDesc() {
        return productoDesc;
    }

    public void setProductoDesc(String productoDesc) {
        this.productoDesc = productoDesc;
    }

    public double getProductoCosto() {
        return productoCosto;
    }

    public void setProductoCosto(double productoCosto) {
        this.productoCosto = productoCosto;
    }

    @XmlTransient
    public List<CfCompra> getCfCompraList() {
        return cfCompraList;
    }

    public void setCfCompraList(List<CfCompra> cfCompraList) {
        this.cfCompraList = cfCompraList;
    }

    @XmlTransient
    public List<CfDetalle> getCfDetalleList() {
        return cfDetalleList;
    }

    public void setCfDetalleList(List<CfDetalle> cfDetalleList) {
        this.cfDetalleList = cfDetalleList;
    }

    public CfTipoProducto getTipoProductoId() {
        return tipoProductoId;
    }

    public void setTipoProductoId(CfTipoProducto tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
    }

    public CfMedida getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(CfMedida medidaId) {
        this.medidaId = medidaId;
    }

    @XmlTransient
    public List<CfCompraDetalle> getCfCompraDetalleList() {
        return cfCompraDetalleList;
    }

    public void setCfCompraDetalleList(List<CfCompraDetalle> cfCompraDetalleList) {
        this.cfCompraDetalleList = cfCompraDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoId != null ? productoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfProducto)) {
            return false;
        }
        CfProducto other = (CfProducto) object;
        if ((this.productoId == null && other.productoId != null) || (this.productoId != null && !this.productoId.equals(other.productoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfProducto[ productoId=" + productoId + " ]";
    }
    
}
