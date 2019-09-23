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
@Table(name = "cf_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfCompra.findAll", query = "SELECT c FROM CfCompra c")})
public class CfCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compra_id")
    private Integer compraId;
    @Basic(optional = false)
    @Column(name = "compra_descripcion")
    private String compraDescripcion;
    @Basic(optional = false)
    @Column(name = "compra_precio")
    private double compraPrecio;
    @JoinColumn(name = "proveedor_id", referencedColumnName = "proveedor_id")
    @ManyToOne(optional = false)
    private CfProveedor proveedorId;
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private CfProducto productoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraId")
    private List<CfCompraDetalle> cfCompraDetalleList;

    public CfCompra() {
    }

    public CfCompra(Integer compraId) {
        this.compraId = compraId;
    }

    public CfCompra(Integer compraId, String compraDescripcion, double compraPrecio) {
        this.compraId = compraId;
        this.compraDescripcion = compraDescripcion;
        this.compraPrecio = compraPrecio;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public String getCompraDescripcion() {
        return compraDescripcion;
    }

    public void setCompraDescripcion(String compraDescripcion) {
        this.compraDescripcion = compraDescripcion;
    }

    public double getCompraPrecio() {
        return compraPrecio;
    }

    public void setCompraPrecio(double compraPrecio) {
        this.compraPrecio = compraPrecio;
    }

    public CfProveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(CfProveedor proveedorId) {
        this.proveedorId = proveedorId;
    }

    public CfProducto getProductoId() {
        return productoId;
    }

    public void setProductoId(CfProducto productoId) {
        this.productoId = productoId;
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
        hash += (compraId != null ? compraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfCompra)) {
            return false;
        }
        CfCompra other = (CfCompra) object;
        if ((this.compraId == null && other.compraId != null) || (this.compraId != null && !this.compraId.equals(other.compraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfCompra[ compraId=" + compraId + " ]";
    }
    
}
