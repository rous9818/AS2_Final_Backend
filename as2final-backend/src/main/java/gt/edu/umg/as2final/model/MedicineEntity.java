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
@Table(name = "tb_medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMedicine.findAll", query = "SELECT t FROM TbMedicine t"),
    @NamedQuery(name = "TbMedicine.findById", query = "SELECT t FROM TbMedicine t WHERE t.id = :id"),
    @NamedQuery(name = "TbMedicine.findByMedicineName", query = "SELECT t FROM TbMedicine t WHERE t.medicineName = :medicineName"),
    @NamedQuery(name = "TbMedicine.findByDescription", query = "SELECT t FROM TbMedicine t WHERE t.description = :description")})
public class MedicineEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "medicine_name")
    private String medicineName;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbMedicine")
    private PrescriptionEntity tbPrescription;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbMedicine")
    private MedicineForDiseaseEntity tbMedicinefordisease;

    public MedicineEntity() {
    }

    public MedicineEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public PrescriptionEntity getTbPrescription() {
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
        return "gt.edu.umg.as2final.model.TbMedicine[ id=" + id + " ]";
    }
    
}
