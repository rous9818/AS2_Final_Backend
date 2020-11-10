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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AK272DT
 */
@Entity
@Table(name = "tb_doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDoctor.findAll", query = "SELECT t FROM TbDoctor t"),
    @NamedQuery(name = "TbDoctor.findById", query = "SELECT t FROM TbDoctor t WHERE t.id = :id"),
    @NamedQuery(name = "TbDoctor.findByFirstName", query = "SELECT t FROM TbDoctor t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TbDoctor.findByMiddleName", query = "SELECT t FROM TbDoctor t WHERE t.middleName = :middleName"),
    @NamedQuery(name = "TbDoctor.findByLastName", query = "SELECT t FROM TbDoctor t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TbDoctor.findByMaidenName", query = "SELECT t FROM TbDoctor t WHERE t.maidenName = :maidenName"),
    @NamedQuery(name = "TbDoctor.findByAddress1", query = "SELECT t FROM TbDoctor t WHERE t.address1 = :address1"),
    @NamedQuery(name = "TbDoctor.findByAddress2", query = "SELECT t FROM TbDoctor t WHERE t.address2 = :address2"),
    @NamedQuery(name = "TbDoctor.findByGender", query = "SELECT t FROM TbDoctor t WHERE t.gender = :gender"),
    @NamedQuery(name = "TbDoctor.findByBirthdate", query = "SELECT t FROM TbDoctor t WHERE t.birthdate = :birthdate"),
    @NamedQuery(name = "TbDoctor.findByCollegiateNumber", query = "SELECT t FROM TbDoctor t WHERE t.collegiateNumber = :collegiateNumber"),
    @NamedQuery(name = "TbDoctor.findByIsActive", query = "SELECT t FROM TbDoctor t WHERE t.isActive = :isActive")})
public class DoctorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "middle_name")
    private String middleName;
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 50)
    @Column(name = "maiden_name")
    private String maidenName;
    @Size(max = 50)
    @Column(name = "address1")
    private String address1;
    @Size(max = 50)
    @Column(name = "address2")
    private String address2;
    @Column(name = "gender")
    private Character gender;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Size(max = 50)
    @Column(name = "collegiate_number")
    private String collegiateNumber;
    @Column(name = "is_active")
    private Boolean isActive;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbDoctor")
    private DoctorSpecializationEntity tbDoctorspecialization;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbDoctor")
    private ConsultationEntity tbConsultation;

    public DoctorEntity() {
    }

    public DoctorEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCollegiateNumber() {
        return collegiateNumber;
    }

    public void setCollegiateNumber(String collegiateNumber) {
        this.collegiateNumber = collegiateNumber;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public DoctorSpecializationEntity getTbDoctorspecialization() {
        return tbDoctorspecialization;
    }

    public void setTbDoctorspecialization(DoctorSpecializationEntity tbDoctorspecialization) {
        this.tbDoctorspecialization = tbDoctorspecialization;
    }

    public ConsultationEntity getTbConsultation() {
        return tbConsultation;
    }

    public void setTbConsultation(ConsultationEntity tbConsultation) {
        this.tbConsultation = tbConsultation;
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
        if (!(object instanceof DoctorEntity)) {
            return false;
        }
        DoctorEntity other = (DoctorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.TbDoctor[ id=" + id + " ]";
    }
    
}
