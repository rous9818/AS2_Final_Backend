package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.DiseaseEntity;
import gt.edu.umg.as2final.service.DiseaseEntityService;
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
 * Controlador DiseaseController
 * @author AK272DT
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class DiseaseController {
    
    @Autowired
    DiseaseEntityService diseaseService;
    
    @GetMapping("/diseases")
    public List<DiseaseEntity> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }
    
    @GetMapping("/diseases/{id}")
    public ResponseEntity<DiseaseEntity> getDiseaseById(@PathVariable(value = "id") Long idDisease)
            throws ResourceNotFoundException {
        return diseaseService.getDiseaseById(idDisease);
    }
    
    @PostMapping("/diseases")
    public DiseaseEntity createDisease(@Valid @RequestBody DiseaseEntity disease) {
        return diseaseService.createDisease(disease);
    }
    
    @PutMapping("/diseases/{id}")
    public ResponseEntity<DiseaseEntity> updateDisease(
        @PathVariable(value = "id") Long idDisease, @Valid @RequestBody DiseaseEntity diseaseDetails)
        throws ResourceNotFoundException {
        return diseaseService.updateDisease(idDisease, diseaseDetails);
    }
    
    @DeleteMapping("/diseases/{id}")
    public Map<String, Boolean> deleteDisease (@PathVariable(value = "id") Long diseaseId)
        throws Exception {
        return diseaseService.deleteDisease(diseaseId);
    }
}
