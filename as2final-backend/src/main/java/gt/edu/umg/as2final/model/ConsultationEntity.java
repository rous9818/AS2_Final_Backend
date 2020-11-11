/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2final.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_consultation")
public class ConsultationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "patient_id")
    private Integer patientId;
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Size(max = 100)
    @Column(name = "complaints")
    private String complaints;
    @Size(max = 100)
    @Column(name = "diagnosis")
    private String diagnosis;
    @Size(max = 100)
    @Column(name = "treatment")
    private String treatment;
    @Column(name = "date_recorded")
    @Temporal(TemporalType.DATE)
    private Date dateRecorded;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbConsultation")
    private PrescriptionEntity tbPrescription;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DoctorEntity tbDoctor;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PatientEntity tbPatient;

    public ConsultationEntity() {
    }

    public ConsultationEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public PrescriptionEntity getTbPrescription() {
        return tbPrescription;
    }

    public void setTbPrescription(PrescriptionEntity tbPrescription) {
        this.tbPrescription = tbPrescription;
    }

    public DoctorEntity getTbDoctor() {
        return tbDoctor;
    }

    public void setTbDoctor(DoctorEntity tbDoctor) {
        this.tbDoctor = tbDoctor;
    }

    public PatientEntity getTbPatient() {
        return tbPatient;
    }

    public void setTbPatient(PatientEntity tbPatient) {
        this.tbPatient = tbPatient;
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
        if (!(object instanceof ConsultationEntity)) {
            return false;
        }
        ConsultationEntity other = (ConsultationEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.TbConsultation[ id=" + id + " ]";
    }
    
}
