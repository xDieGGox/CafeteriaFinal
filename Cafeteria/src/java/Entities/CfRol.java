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
@Table(name = "cf_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfRol.findAll", query = "SELECT c FROM CfRol c")})
public class CfRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Basic(optional = false)
    @Column(name = "rol_descripcion")
    private int rolDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<CfEmpleado> cfEmpleadoList;

    public CfRol() {
    }

    public CfRol(Integer rolId) {
        this.rolId = rolId;
    }

    public CfRol(Integer rolId, int rolDescripcion) {
        this.rolId = rolId;
        this.rolDescripcion = rolDescripcion;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public int getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(int rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
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
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfRol)) {
            return false;
        }
        CfRol other = (CfRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.CfRol[ rolId=" + rolId + " ]";
    }
    
}
