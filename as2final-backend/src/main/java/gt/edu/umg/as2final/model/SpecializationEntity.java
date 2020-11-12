package gt.edu.umg.as2final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author AK272DT
 * SpecializationEntity:
 * Modelo para representar el catálogo de especializaciones.
 */
@Entity
@Table(name = "tb_specialization")
public class SpecializationEntity implements Serializable {

    // Id de la especialización
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    // Nombre de la especialización
    @Size(max = 50)
    @Column(name = "specialization_name")
    private String specializationName;
    
    // Descripción de la especialización
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "tbSpecialization")
    private DoctorSpecializationEntity tbDoctorspecialization;*/

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

    /* public DoctorSpecializationEntity getTbDoctorspecialization() {
        return tbDoctorspecialization;
    }

    public void setTbDoctorspecialization(DoctorSpecializationEntity tbDoctorspecialization) {
        this.tbDoctorspecialization = tbDoctorspecialization;
    } */

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
        return "gt.edu.umg.as2final.model.SpecializationEntity[ id=" + id + " ]";
    }
    
}
