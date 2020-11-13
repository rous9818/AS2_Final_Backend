package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.PatientEntity;
import gt.edu.umg.as2final.service.PatientEntityService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador PatientController
 * @author AK272DT
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class PatientController {
    
    @Autowired
    PatientEntityService patientService;
    
    /**
     * Obtiene la lista de todos los pacientes
     * @return List<PatientEntity> 
     */
    @GetMapping("/patients")
    public List<PatientEntity> getAllPatients() {
        return patientService.getAllPatients();
    }
    
    /**
     * Obtiene el detalle de un recurso de tipo PatientEntity, por id
     * @param idPatient
     * @return ResponseEntity<PatientEntity> 
     * @throws ResourceNotFoundException 
     */
    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientEntity> getUsersById(@PathVariable(value = "id") Long idPatient)
        throws ResourceNotFoundException {
        return patientService.getUsersById(idPatient);
    }
    
    /**
     * Permite crear un recurso de tipo PatientEntity
     * @param patient
     * @return PatientEntity
     */
    @PostMapping("/patients")
    public PatientEntity createPatient(@Valid @RequestBody PatientEntity patient){
        return patientService.createPatient(patient);
    }
    
    /**
     * Permite actualizar un recurso de tipo PatientEntity, por id
     * @param idPatient
     * @param patientDetails
     * @return ResponseEntity<PatientEntity> 
     * @throws ResourceNotFoundException 
     */
    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientEntity> updatePatient(
        @PathVariable(value = "id") Long idPatient, @Valid @RequestBody PatientEntity patientDetails) 
        throws ResourceNotFoundException {
        return patientService.updatePatient(idPatient, patientDetails);
    }
    
    /**
     * Permite eliminar un recurso de tipo PatientEntity
     * @param patientId
     * @return Map<String, Boolean> 
     * @throws Exception 
     */
    @DeleteMapping("/patients/{id}")
    public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long patientId) 
        throws Exception { 
        return patientService.deletePatient(patientId);
    }
}
