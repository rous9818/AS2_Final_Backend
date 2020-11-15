package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.SpecializationEntity;
import gt.edu.umg.as2final.service.SpecializationEntityService;
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
 * Controlador SpecializationController
 * @author AK272DT
 */
@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class SpecializationController {
    
    @Autowired
    SpecializationEntityService specializationService;
    
    @GetMapping("/specializations")
    public List<SpecializationEntity> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }
    
    @GetMapping("/specializations/{id}")
    public ResponseEntity<SpecializationEntity> getSpecializationById(@PathVariable(value = "id") Long idSpecialization)
            throws ResourceNotFoundException {
        return specializationService.getSpecializationById(idSpecialization);
    }
    
    @PostMapping("/specializations")
    public SpecializationEntity createSpecialization(@Valid @RequestBody SpecializationEntity specialization) {
        return specializationService.createSpecialization(specialization);
    }
    
    @PutMapping("/specializations/{id}")
    public ResponseEntity<SpecializationEntity> updateSpecialization(
        @PathVariable(value = "id") Long idSpecialization, @Valid @RequestBody SpecializationEntity specializationDetails)
        throws ResourceNotFoundException {
        return specializationService.updateSpecialization(idSpecialization, specializationDetails);
    }
    
    @DeleteMapping("/specializations/{id}")
    public Map<String, Boolean> deleteSpecialization (@PathVariable(value = "id") Long specializationId)
        throws Exception {
        return specializationService.deleteSpecialization(specializationId);
    }
}
