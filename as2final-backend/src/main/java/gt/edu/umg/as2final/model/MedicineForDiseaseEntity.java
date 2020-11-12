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
 * MedicineForDiseaseEntity:
 * Modelo para representar los medicamentos asociados a una enfermedad(es).
 */
@Entity
@Table(name = "tb_medicinefordisease")
public class MedicineForDiseaseEntity implements Serializable {

    // Id medicamento-enfermedad
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    // Id de la enfermedad
    @Column(name = "disease_id")
    private Integer diseaseId;
    
    // Id del medicamento
    @Column(name = "medicine_id")
    private Integer medicineId;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DiseaseEntity tbDisease;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MedicineEntity tbMedicine;

    public MedicineForDiseaseEntity() {
    }

    public MedicineForDiseaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public DiseaseEntity getTbDisease() {
        return tbDisease;
    }

    public void setTbDisease(DiseaseEntity tbDisease) {
        this.tbDisease = tbDisease;
    }

    public MedicineEntity getTbMedicine() {
        return tbMedicine;
    }

    public void setTbMedicine(MedicineEntity tbMedicine) {
        this.tbMedicine = tbMedicine;
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
        if (!(object instanceof MedicineForDiseaseEntity)) {
            return false;
        }
        MedicineForDiseaseEntity other = (MedicineForDiseaseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.MedicineForDiseaseEntity[ id=" + id + " ]";
    }
    
}
