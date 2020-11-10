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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPrescription.findAll", query = "SELECT t FROM TbPrescription t"),
    @NamedQuery(name = "TbPrescription.findById", query = "SELECT t FROM TbPrescription t WHERE t.id = :id"),
    @NamedQuery(name = "TbPrescription.findByConsultationId", query = "SELECT t FROM TbPrescription t WHERE t.consultationId = :consultationId"),
    @NamedQuery(name = "TbPrescription.findByMedicineId", query = "SELECT t FROM TbPrescription t WHERE t.medicineId = :medicineId"),
    @NamedQuery(name = "TbPrescription.findByPrescriptionDetails", query = "SELECT t FROM TbPrescription t WHERE t.prescriptionDetails = :prescriptionDetails")})
public class PrescriptionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "consultation_id")
    private Integer consultationId;
    @Column(name = "medicine_id")
    private Integer medicineId;
    @Size(max = 150)
    @Column(name = "prescription_details")
    private String prescriptionDetails;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ConsultationEntity tbConsultation;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MedicineEntity tbMedicine;

    public PrescriptionEntity() {
    }

    public PrescriptionEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Integer consultationId) {
        this.consultationId = consultationId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(String prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public ConsultationEntity getTbConsultation() {
        return tbConsultation;
    }

    public void setTbConsultation(ConsultationEntity tbConsultation) {
        this.tbConsultation = tbConsultation;
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
        if (!(object instanceof PrescriptionEntity)) {
            return false;
        }
        PrescriptionEntity other = (PrescriptionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.TbPrescription[ id=" + id + " ]";
    }
    
}