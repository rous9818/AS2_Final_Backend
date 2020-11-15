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
 * MedicineEntity:
 * Modelo para representar el catálogo de medicamentos.
 */
@Entity
@Table(name = "tb_medicine")
public class MedicineEntity implements Serializable {

    // Id del medicamento
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    // Nombre del medicamento
    @Size(max = 30)
    @Column(name = "medicine_name")
    private String medicineName;
    
    // Descripción del medicamento
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "tbMedicine")
    private PrescriptionEntity tbPrescription;*/
    
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "tbMedicine")
    private MedicineForDiseaseEntity tbMedicinefordisease;*/

    public MedicineEntity() {
    }

    public MedicineEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public PrescriptionEntity getTbPrescription() {
        return tbPrescription;
    }

    public void setTbPrescription(PrescriptionEntity tbPrescription) {
        this.tbPrescription = tbPrescription;
    }

    public MedicineForDiseaseEntity getTbMedicinefordisease() {
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
        if (!(object instanceof MedicineEntity)) {
            return false;
        }
        MedicineEntity other = (MedicineEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.MedicineEntity[ id=" + id + " ]";
    }
    
}
