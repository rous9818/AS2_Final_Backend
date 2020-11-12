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
 * DiseaseEntity
 * Modelo para representar un catálogo de enfermedades
 */
@Entity
@Table(name = "tb_disease")
public class DiseaseEntity implements Serializable {

    // Id de la enfermedad
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    // Nombre de la enferemdad
    @Size(max = 30)
    @Column(name = "disease_name")
    private String diseaseName;
    
    // Descripción de la enfermedad
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "tbDisease")
    private MedicineForDiseaseEntity tbMedicinefordisease;*/

    public DiseaseEntity() {
    }

    public DiseaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* public MedicineForDiseaseEntity getTbMedicinefordisease() {
        return tbMedicinefordisease;
    }

    public void setTbMedicinefordisease(MedicineForDiseaseEntity tbMedicinefordisease) {
        this.tbMedicinefordisease = tbMedicinefordisease;
    }*/ 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiseaseEntity)) {
            return false;
        }
        DiseaseEntity other = (DiseaseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.DiseaseEntity[ id=" + id + " ]";
    }
    
}
