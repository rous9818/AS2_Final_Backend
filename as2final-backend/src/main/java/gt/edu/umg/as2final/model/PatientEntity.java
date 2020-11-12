package gt.edu.umg.as2final.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author AK272DT
 * PatientEntity: 
 * Modelo para representar los pacientes.
 */
@Entity
@Table(name = "tb_patient")
public class PatientEntity implements Serializable {

    // Id del paciente
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    // Primer nombre
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    
    // Segundo nombre
    @Size(max = 50)
    @Column(name = "middle_name")
    private String middleName;
    
    // Primer apellido
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    
    // Apellido materno
    @Size(max = 50)
    @Column(name = "maiden_name")
    private String maidenName;
    
    // Dirección principal
    @Size(max = 50)
    @Column(name = "address1")
    private String address1;
    
    // Dirección secundaria
    @Size(max = 50)
    @Column(name = "address2")
    private String address2;
    
    // Teléfono principal
    @Size(max = 50)
    @Column(name = "phone1")
    private String phone1;
    
    // Teléfono secundario
    @Size(max = 50)
    @Column(name = "phone2")
    private String phone2;
    
    // Género (M o F)
    @Column(name = "gender")
    private Character gender;
    
    // Fecha de nacimiento
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    // Estado del paciente
    @Column(name = "patient_state")
    private Boolean patientState;

    public PatientEntity() {
    }

    public PatientEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
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

    public Boolean getPatientState() {
        return patientState;
    }

    public void setPatientState(Boolean patientState) {
        this.patientState = patientState;
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
        if (!(object instanceof PatientEntity)) {
            return false;
        }
        PatientEntity other = (PatientEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.as2final.model.PatientEntity[ id=" + id + " ]";
    }
    
}
