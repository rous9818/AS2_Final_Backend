package gt.edu.umg.as2final.service;

import gt.edu.umg.as2final.dao.DiseaseRepository;
import gt.edu.umg.as2final.model.DiseaseEntity;
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
 * Servicio DiseaseEntityService
 * Permite implementar todas las operaciones del CRUD para la entidad DiseaseEntityService
 * @author AK272DT
 */
@Service
public class DiseaseEntityService {
    
    @Autowired
    private DiseaseRepository diseaseRepository;
    
    /**
     * Obtiene la lista completa de enfermedades
     * 
     * @return Lista de enfermedades 
     */
    public List<DiseaseEntity> getAllDiseases() {
        return diseaseRepository.findAll();
    }
    
    /**
     * Obtiene el detalle de una enfermedad por id
     * 
     * @param idDisease Id de la enfermedad
     * @return Detalle de la enfermedad
     * @throws ResourceNotFoundException en dado caso no se encuentre el recurso 
     */
    public ResponseEntity<DiseaseEntity> getDiseaseById(@PathVariable(value = "id") Long idDisease)
            throws ResourceNotFoundException {
        
        DiseaseEntity disease = 
                diseaseRepository
                    .findById(idDisease)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la enfermedad con el id : " + idDisease));
        
        return ResponseEntity.ok().body(disease);
    }
    
    /**
     * Crea una nueva enfermedad en la base de datos.
     * 
     * @param disease entidad DiseaseEntity
     * @return La enfermedad creada
     */
    public DiseaseEntity createDisease(@Valid @RequestBody DiseaseEntity disease) {
        return diseaseRepository.save(disease);
    }
    
    /**
     * Actualiza la entidad DiseaseEntity
     * 
     * @param idDisease Id de la enfermedad
     * @param diseaseDetails Detalle de la enfermedad
     * @return La enfermdad con los datos modificados
     * @throws ResourceNotFoundException  en dado caso no se encuentre el recurso
     */
    public ResponseEntity<DiseaseEntity> updateDisease(
        @PathVariable(value = "id") Long idDisease, @Valid @RequestBody DiseaseEntity diseaseDetails)
        throws ResourceNotFoundException {
        
        DiseaseEntity disease = 
                diseaseRepository
                    .findById(idDisease)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la enfermedad con id : " + idDisease));
        
        disease.setDiseaseName(diseaseDetails.getDiseaseName());
        disease.setDescription(diseaseDetails.getDescription());
        
        final DiseaseEntity updatedDisease = diseaseRepository.save(disease);
        return ResponseEntity.ok(updatedDisease);
    }
    
    /**
     * Elimina una 
     * @param diseaseId Id de la enfermedad
     * @return deleted = true si fue eliminado, false en caso contrario
     * @throws Exception La excepción 
     */
    public Map<String, Boolean> deleteDisease (@PathVariable(value = "id") Long diseaseId)
        throws Exception {
        
        DiseaseEntity disease = 
                diseaseRepository
                    .findById(diseaseId)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la enfermedad con el id : " + diseaseId));
        
        diseaseRepository.delete(disease);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return response;
    }
}
