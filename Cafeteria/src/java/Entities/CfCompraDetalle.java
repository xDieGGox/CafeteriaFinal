/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;  
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cf_compra_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfCompraDetalle.findAll", query = "SELECT c FROM CfCompraDetalle c")})
public class CfCompraDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compra_detalle_id")
    private Integer compraDetalleId;
    @Basic(optional = false)
    @Column(name = "compra_detalle_total")
    private String compraDetalleTotal;
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private CfProducto productoId;
    @JoinColumn(name = "compra_id", referencedColumnName = "compra_id")
    @ManyToOne(optional = false)
    private CfCompra compraId;

    public CfCompraDetalle() {
    }

    public CfCompraDetalle(Integer compraDetalleId) {
        this.compraDetalleId = compraDetalleId;
    }

    public CfCompraDetalle(Integer compraDetalleId, String compraDetalleTotal) {
        this.compraDetalleId = compraDetalleId;
        this.compraDetalleTotal = compraDetalleTotal;
    }

    public Integer getCompraDetalleId() {
        return compraDetalleId;
    }

    public void setCompraDetalleId(Integer compraDetalleId) {
        this.compraDetalleId = compraDetalleId;
    }

    public String getCompraDetalleTotal() {
        return compraDetalleTotal;
    }

    public void setCompraDetalleTotal(String compraDetalleTotal) {
        this.compraDetalleTotal = compraDetalleTotal;
    }

    public CfProducto getProductoId() {
        return productoId;
    }

    public void setProductoId(CfProducto productoId) {
        this.productoId = productoId;
    }

    public CfCompra getCompraId() {
        return compraId;
    }

    public void setCompraId(CfCompra compraId) {
        this.compraId = compraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraDetalleId != null ? compraDetalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfCompraDetalle)) {
            return false;
        }
        CfCompraDetalle other = (CfCompraDetalle) object;
        if ((this.compraDetalleId == null && other.compraDetalleId != null) || (this.compraDetalleId != null && !this.compraDetalleId.equals(other.compraDetalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfCompraDetalle[ compraDetalleId=" + compraDetalleId + " ]";
    }
    
}
