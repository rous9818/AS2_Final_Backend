/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_specialization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSpecialization.findAll", query = "SELECT t FROM TbSpecialization t"),
    @NamedQuery(name = "TbSpecialization.findById", query = "SELECT t FROM TbSpecialization t WHERE t.id = :id"),
    @NamedQuery(name = "TbSpecialization.findBySpecializationName", query = "SELECT t FROM TbSpecialization t WHERE t.specializationName = :specializationName"),
    @NamedQuery(name = "TbSpecialization.findByDescription", query = "SELECT t FROM TbSpecialization t WHERE t.description = :description")})
public class SpecializationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "specialization_name")
    private String specializationName;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbSpecialization")
    private DoctorSpecializationEntity tbDoctorspecialization;

    public SpecializationEntity() {
    }

    public SpecializationEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DoctorSpecializationEntity getTbDoctorspecialization() {
        return tbDoctorspecialization;
    }

    public void setTbDoctorspecialization(DoctorSpecializationEntity tbDoctorspecialization) {
        this.tbDoctorspecialization = tbDoctorspecialization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecializationEntity)) {
            return false;
        }
        SpecializationEntity other = (SpecializationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.TbSpecialization[ id=" + id + " ]";
    }
    
}
