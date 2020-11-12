package gt.edu.umg.as2final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_doctorspecialization")
public class DoctorSpecializationEntity implements Serializable {

    // Id doctor-especialización
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    // Id del doctor
    @Column(name = "doctor_id")
    private Integer doctorId;
    
    // Id del paciente
    @Column(name = "specialization_id")
    private Integer specializationId;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DoctorEntity tbDoctor;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SpecializationEntity tbSpecialization;

    public DoctorSpecializationEntity() {
    }

    public DoctorSpecializationEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public DoctorEntity getTbDoctor() {
        return tbDoctor;
    }

    public void setTbDoctor(DoctorEntity tbDoctor) {
        this.tbDoctor = tbDoctor;
    }

    public SpecializationEntity getTbSpecialization() {
        return tbSpecialization;
    }

    public void setTbSpecialization(SpecializationEntity tbSpecialization) {
        this.tbSpecialization = tbSpecialization;
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
        if (!(object instanceof DoctorSpecializationEntity)) {
            return false;
        }
        DoctorSpecializationEntity other = (DoctorSpecializationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.DoctorSpecializationEntity[ id=" + id + " ]";
    }
    
}
