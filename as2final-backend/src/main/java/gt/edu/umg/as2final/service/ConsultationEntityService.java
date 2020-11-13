package gt.edu.umg.as2final.service;

import gt.edu.umg.as2final.dao.ConsultationRepository;
import gt.edu.umg.as2final.model.ConsultationEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controlador ConsultationEntityService
 Permite implementar todas las operaciones del CRUD para la entidad ConsultationEntity
 * @author AK272DT
 */
@Service
public class ConsultationEntityService {
    
    @Autowired
    private ConsultationRepository consultationRepository;
    
    /**
     * Obtiene la lista completa de consultas
     * 
     * @return Lista de consultas 
     */
    public List<ConsultationEntity> getAllConsultations() {
        return consultationRepository.findAll();
    }
    
    /**
     * Obtiene el detalle de una consulta por id
     * 
     * @param idConsultation Id de la consulta
     * @return Detalle de la consulta
     * @throws ResourceNotFoundException en dado caso no encuentre el recurso 
     */
    public ResponseEntity<ConsultationEntity> getConsultationsById(@PathVariable(value = "id") Long idConsultation)
        throws ResourceNotFoundException {
        
        ConsultationEntity consultation = 
                consultationRepository
                    .findById(idConsultation)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la consulta con el id : " + idConsultation));
        
        return ResponseEntity.ok().body(consultation);
    }
    
    /**
     * Crea una nueva consulta en la base de datos.
     * 
     * @param consultation La consulta
     * @return La consulta creada
     */
    public ConsultationEntity createConsultation(@Valid @RequestBody ConsultationEntity consultation){
        return consultationRepository.save(consultation);
    }
    
    /**
     * Actualiza la entidad ConsultationEntity
     * 
     * @param idConsultation Id de la consulta
     * @param consultationDetails Detalle de la consulta
     * @return La consulta con los datos modificados
     * @throws ResourceNotFoundException en dado caso no se encuentre el recurso
     */
    public ResponseEntity<ConsultationEntity> updateConsultation(
        @PathVariable(value = "id") Long idConsultation, @Valid @RequestBody ConsultationEntity consultationDetails)
        throws ResourceNotFoundException {
        
        ConsultationEntity consultation = 
                consultationRepository
                    .findById(idConsultation)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la consulta con id : " + idConsultation));
        
        consultation.setDateRecorded(consultationDetails.getDateRecorded());
        consultation.setDiagnosis(consultationDetails.getDiagnosis());
        consultation.setTreatment(consultationDetails.getTreatment());
        consultation.setComplaints(consultationDetails.getComplaints());
        
        final ConsultationEntity updatedConsultation = consultationRepository.save(consultation);
        return ResponseEntity.ok(updatedConsultation);
    }
    
    /**
     * Elimina una consulta de la base de datos
     * 
     * @param consultationId Id de la consulta
     * @return deleted = true si fue eliminado, false en caso contrario
     * @throws Exception La excepción
     */
    public Map<String, Boolean> deleteConsultation (@PathVariable(value = "id") Long consultationId) 
        throws Exception {
        
        ConsultationEntity consultation = 
                consultationRepository
                    .findById(consultationId)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la consulta con el id : " + consultationId));
        
        consultationRepository.delete(consultation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return response;
    }
}
