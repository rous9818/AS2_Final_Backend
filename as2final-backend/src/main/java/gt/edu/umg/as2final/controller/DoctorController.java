package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.DoctorEntity;
import gt.edu.umg.as2final.service.DoctorEntityService;
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
 * Controlador DoctorController
 * @author AK272DT
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class DoctorController {
    
    @Autowired
    DoctorEntityService doctorService;
    
    /**
     * Obtiene la lista de todos los médicos de la clínica
     * @return List<PatientEntity> 
     */
    @GetMapping("/doctors")
    public List<DoctorEntity> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    
    /**
     * Obtiene el detalle de un recurso de tipo DoctorEntity, por id
     * @param idDoctor
     * @return ResponseEntity<DoctorEntity> 
     * @throws ResourceNotFoundException 
     */
    @GetMapping("/doctors/{id}")
    public ResponseEntity getDoctorsById(@PathVariable(value = "id") Long idDoctor)
        throws ResourceNotFoundException {  
        return doctorService.getDoctorsById(idDoctor);
    }
    
    /**
     * Permite crear un recurso de tipo DoctorEntity
     * @param doctor
     * @return DoctorEntity
     */
    @PostMapping("/doctors")
    public DoctorEntity createDoctor(@Valid @RequestBody DoctorEntity doctor){
        return doctorService.createDoctor(doctor);
    }
    
    /**
     * Permite actualizar un recurso de tipo DoctorEntity, por id
     * @param idDoctor
     * @param doctorDetails
     * @return ResponseEntity<DoctorEntity> 
     * @throws ResourceNotFoundException 
     */
    @PutMapping("/doctors/{id}")
    public ResponseEntity<DoctorEntity> updateDoctor(
        @PathVariable(value = "id") Long idDoctor, @Valid @RequestBody DoctorEntity doctorDetails) 
        throws ResourceNotFoundException {
        return doctorService.updateDoctor(idDoctor, doctorDetails);
    }
    
    /**
     * Permite eliminar un recurso de tipo DoctorEntity
     * @param doctorId
     * @return Map<String, Boolean> 
     * @throws Exception 
     */
    @DeleteMapping("/doctors/{id}")
    public Map<String, Boolean> deleteDoctor(@PathVariable(value = "id") Long doctorId) 
        throws Exception {
        return doctorService.deleteDoctor(doctorId);
    }
}
