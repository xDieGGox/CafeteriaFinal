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
@Table(name = "cf_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfHorario.findAll", query = "SELECT c FROM CfHorario c")})
public class CfHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "horario_id")
    private Integer horarioId;
    @Basic(optional = false)
    @Column(name = "horario_entrada")
    @Temporal(TemporalType.TIME)
    private Date horarioEntrada;
    @Basic(optional = false)
    @Column(name = "horario_salida")
    @Temporal(TemporalType.TIME)
    private Date horarioSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioId")
    private List<CfEmpleado> cfEmpleadoList;

    public CfHorario() {
    }

    public CfHorario(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public CfHorario(Integer horarioId, Date horarioEntrada, Date horarioSalida) {
        this.horarioId = horarioId;
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    @XmlTransient
    public List<CfEmpleado> getCfEmpleadoList() {
        return cfEmpleadoList;
    }

    public void setCfEmpleadoList(List<CfEmpleado> cfEmpleadoList) {
        this.cfEmpleadoList = cfEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioId != null ? horarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfHorario)) {
            return false;
        }
        CfHorario other = (CfHorario) object;
        if ((this.horarioId == null && other.horarioId != null) || (this.horarioId != null && !this.horarioId.equals(other.horarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfHorario[ horarioId=" + horarioId + " ]";
    }
    
}
