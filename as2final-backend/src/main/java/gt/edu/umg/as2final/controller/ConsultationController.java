package gt.edu.umg.as2final.controller;

import gt.edu.umg.as2final.model.ConsultationEntity;
import gt.edu.umg.as2final.service.ConsultationEntityService;
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
 * Controlador ConsultationController
 * @author AK272DT
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ConsultationController {
    
    @Autowired
    ConsultationEntityService consultationService;
    
    @GetMapping("/consultations")
    public List<ConsultationEntity> getAllConsultations() {
        return consultationService.getAllConsultations();
    }
    
    @GetMapping("/consultations/{id}")
    public ResponseEntity<ConsultationEntity> getConsultationsById(@PathVariable(value = "id") Long idConsultation)
        throws ResourceNotFoundException {   
        return consultationService.getConsultationsById(idConsultation);
    }
    
    @PostMapping("/consultations")
    public ConsultationEntity createConsultation(@Valid @RequestBody ConsultationEntity consultation){
        return consultationService.createConsultation(consultation);
    }
    
    @PutMapping("/consultations/{id}")
    public ResponseEntity<ConsultationEntity> updateConsultation(
        @PathVariable(value = "id") Long idConsultation, @Valid @RequestBody ConsultationEntity consultationDetails)
        throws ResourceNotFoundException {
        return consultationService.updateConsultation(idConsultation, consultationDetails);
    }
    
    @DeleteMapping("/consultations/{id}")
    public Map<String, Boolean> deleteConsultation (@PathVariable(value = "id") Long consultationId) 
        throws Exception {
        return consultationService.deleteConsultation(consultationId);
    }
}
