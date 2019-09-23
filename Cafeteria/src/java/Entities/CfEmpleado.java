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
@Table(name = "cf_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfEmpleado.findAll", query = "SELECT c FROM CfEmpleado c")})
public class CfEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empleado_id")
    private Integer empleadoId;
    @Basic(optional = false)
    @Column(name = "empleado_sueldo")
    private double empleadoSueldo;
    @Basic(optional = false)
    @Column(name = "empleado_fecha_con")
    @Temporal(TemporalType.DATE)
    private Date empleadoFechaCon;
    @JoinColumn(name = "horario_id", referencedColumnName = "horario_id")
    @ManyToOne(optional = false)
    private CfHorario horarioId;
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    @ManyToOne(optional = false)
    private CfPersona personaId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private CfRol rolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoId")
    private List<CfFactura> cfFacturaList;

    public CfEmpleado() {
    }

    public CfEmpleado(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public CfEmpleado(Integer empleadoId, double empleadoSueldo, Date empleadoFechaCon) {
        this.empleadoId = empleadoId;
        this.empleadoSueldo = empleadoSueldo;
        this.empleadoFechaCon = empleadoFechaCon;
    }

    public Integer getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Integer empleadoId) {
        this.empleadoId = empleadoId;
    }

    public double getEmpleadoSueldo() {
        return empleadoSueldo;
    }

    public void setEmpleadoSueldo(double empleadoSueldo) {
        this.empleadoSueldo = empleadoSueldo;
    }

    public Date getEmpleadoFechaCon() {
        return empleadoFechaCon;
    }

    public void setEmpleadoFechaCon(Date empleadoFechaCon) {
        this.empleadoFechaCon = empleadoFechaCon;
    }

    public CfHorario getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(CfHorario horarioId) {
        this.horarioId = horarioId;
    }

    public CfPersona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(CfPersona personaId) {
        this.personaId = personaId;
    }

    public CfRol getRolId() {
        return rolId;
    }

    public void setRolId(CfRol rolId) {
        this.rolId = rolId;
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
        hash += (empleadoId != null ? empleadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfEmpleado)) {
            return false;
        }
        CfEmpleado other = (CfEmpleado) object;
        if ((this.empleadoId == null && other.empleadoId != null) || (this.empleadoId != null && !this.empleadoId.equals(other.empleadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfEmpleado[ empleadoId=" + empleadoId + " ]";
    }
    
}
