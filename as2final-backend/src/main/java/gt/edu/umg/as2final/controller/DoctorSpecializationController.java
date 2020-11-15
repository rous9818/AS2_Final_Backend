package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.DoctorSpecializationEntity;
import gt.edu.umg.as2final.service.DoctorSpecializationEntityService;
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
 * Controlador DoctorSpecializationController
 * @author AK272DT
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class DoctorSpecializationController {
    
    @Autowired
    DoctorSpecializationEntityService doctorSpecializationService;
    
    @GetMapping("/doctorspecializations")
    public List<DoctorSpecializationEntity> getAllDoctorSpecializations() {
        return doctorSpecializationService.getAllDoctorSpecializations();
    }
    
    @GetMapping("/doctorspecializations/{id}")
    public ResponseEntity<DoctorSpecializationEntity> getDoctorSpecializationById(@PathVariable(value = "id") Long idDoctorSpecialization)
        throws ResourceNotFoundException {
        return doctorSpecializationService.getDoctorSpecializationById(idDoctorSpecialization);
    }
    
    @PostMapping("/doctorspecializations")
    public DoctorSpecializationEntity createDoctorSpecialization(@Valid @RequestBody DoctorSpecializationEntity doctorSpecialization) {
        return doctorSpecializationService.createDoctorSpecialization(doctorSpecialization);
    }
    
    @PutMapping("/doctorspecializations/{id}")
    public ResponseEntity<DoctorSpecializationEntity> updateDoctorSpecialization (
        @PathVariable(value = "id") Long idDoctorSpecialization, @Valid @RequestBody DoctorSpecializationEntity doctorSpecializationDetails)
        throws ResourceNotFoundException {
        return doctorSpecializationService.updateDoctorSpecialization(idDoctorSpecialization, doctorSpecializationDetails);
    }
    
    @DeleteMapping("/doctorspecializations/{id}")
    public Map<String, Boolean> deleteDoctorSpecialization (@PathVariable(value = "id") Long doctorSpecializationId)
        throws Exception {
        return doctorSpecializationService.deleteDoctorSpecialization(doctorSpecializationId);
    }
}
