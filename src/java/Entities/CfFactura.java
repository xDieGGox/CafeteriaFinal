/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cf_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfFactura.findAll", query = "SELECT c FROM CfFactura c")})
public class CfFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @Basic(optional = false)
    @Column(name = "factura_iva")
    private int facturaIva;
    @Basic(optional = false)
    @Column(name = "factura_descuento")
    private double facturaDescuento;
    @Basic(optional = false)
    @Column(name = "factura_total")
    private double facturaTotal;
    @Basic(optional = false)
    @Column(name = "factura_fecha")
    @Temporal(TemporalType.DATE)
    private Date facturaFecha;
    @Basic(optional = false)
    @Column(name = "factura_subtotal")
    private double facturaSubtotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaId")
    private List<CfDetalle> cfDetalleList;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne(optional = false)
    private CfCliente clienteId;
    @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id")
    @ManyToOne(optional = false)
    private CfEmpleado empleadoId;

    public CfFactura() {
    }

    public CfFactura(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public CfFactura(Integer facturaId, int facturaIva, double facturaDescuento, double facturaTotal, Date facturaFecha, double facturaSubtotal) {
        this.facturaId = facturaId;
        this.facturaIva = facturaIva;
        this.facturaDescuento = facturaDescuento;
        this.facturaTotal = facturaTotal;
        this.facturaFecha = facturaFecha;
        this.facturaSubtotal = facturaSubtotal;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public int getFacturaIva() {
        return facturaIva;
    }

    public void setFacturaIva(int facturaIva) {
        this.facturaIva = facturaIva;
    }

    public double getFacturaDescuento() {
        return facturaDescuento;
    }

    public void setFacturaDescuento(double facturaDescuento) {
        this.facturaDescuento = facturaDescuento;
    }

    public double getFacturaTotal() {
        return facturaTotal;
    }

    public void setFacturaTotal(double facturaTotal) {
        this.facturaTotal = facturaTotal;
    }

    public Date getFacturaFecha() {
        return facturaFecha;
    }

    public void setFacturaFecha(Date facturaFecha) {
        this.facturaFecha = facturaFecha;
    }

    public double getFacturaSubtotal() {
        return facturaSubtotal;
    }

    public void setFacturaSubtotal(double facturaSubtotal) {
        this.facturaSubtotal = facturaSubtotal;
    }

    @XmlTransient
    public List<CfDetalle> getCfDetalleList() {
        return cfDetalleList;
    }

    public void setCfDetalleList(List<CfDetalle> cfDetalleList) {
        this.cfDetalleList = cfDetalleList;
    }

    public CfCliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(CfCliente clienteId) {
        this.clienteId = clienteId;
    }

    public CfEmpleado getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(CfEmpleado empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaId != null ? facturaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfFactura)) {
            return false;
        }
        CfFactura other = (CfFactura) object;
        if ((this.facturaId == null && other.facturaId != null) || (this.facturaId != null && !this.facturaId.equals(other.facturaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfFactura[ facturaId=" + facturaId + " ]";
    }
    
}
