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
@Table(name = "cf_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfDetalle.findAll", query = "SELECT c FROM CfDetalle c")})
public class CfDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detalle_id")
    private Integer detalleId;
    @Basic(optional = false)
    @Column(name = "detalle_cantidad")
    private int detalleCantidad;
    @Basic(optional = false)
    @Column(name = "detalle_precio")
    private double detallePrecio;
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    @ManyToOne(optional = false)
    private CfProducto productoId;
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id")
    @ManyToOne(optional = false)
    private CfFactura facturaId;

    public CfDetalle() {
    }

    public CfDetalle(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public CfDetalle(Integer detalleId, int detalleCantidad, double detallePrecio) {
        this.detalleId = detalleId;
        this.detalleCantidad = detalleCantidad;
        this.detallePrecio = detallePrecio;
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public int getDetalleCantidad() {
        return detalleCantidad;
    }

    public void setDetalleCantidad(int detalleCantidad) {
        this.detalleCantidad = detalleCantidad;
    }

    public double getDetallePrecio() {
        return detallePrecio;
    }

    public void setDetallePrecio(double detallePrecio) {
        this.detallePrecio = detallePrecio;
    }

    public CfProducto getProductoId() {
        return productoId;
    }

    public void setProductoId(CfProducto productoId) {
        this.productoId = productoId;
    }

    public CfFactura getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(CfFactura facturaId) {
        this.facturaId = facturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleId != null ? detalleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfDetalle)) {
            return false;
        }
        CfDetalle other = (CfDetalle) object;
        if ((this.detalleId == null && other.detalleId != null) || (this.detalleId != null && !this.detalleId.equals(other.detalleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfDetalle[ detalleId=" + detalleId + " ]";
    }
    
}
