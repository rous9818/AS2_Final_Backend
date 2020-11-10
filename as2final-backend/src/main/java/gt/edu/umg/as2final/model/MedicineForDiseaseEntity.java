/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2final.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_medicinefordisease")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMedicinefordisease.findAll", query = "SELECT t FROM TbMedicinefordisease t"),
    @NamedQuery(name = "TbMedicinefordisease.findById", query = "SELECT t FROM TbMedicinefordisease t WHERE t.id = :id"),
    @NamedQuery(name = "TbMedicinefordisease.findByDiseaseId", query = "SELECT t FROM TbMedicinefordisease t WHERE t.diseaseId = :diseaseId"),
    @NamedQuery(name = "TbMedicinefordisease.findByMedicineId", query = "SELECT t FROM TbMedicinefordisease t WHERE t.medicineId = :medicineId")})
public class MedicineForDiseaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "disease_id")
    private Integer diseaseId;
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

    public MedicineForDiseaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "gt.edu.umg.as2final.model.TbMedicinefordisease[ id=" + id + " ]";
    }
    
}
