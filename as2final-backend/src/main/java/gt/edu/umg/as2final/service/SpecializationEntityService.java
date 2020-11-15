/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2final.service;

import gt.edu.umg.as2final.dao.SpecializationRepository;
import gt.edu.umg.as2final.model.SpecializationEntity;
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
 * Servicio SpecializationEntityService
 Permite implementar todas las operaciones del CRUD para la entidad SpecializationEntity
 * @author AK272DT
 */
@Service
public class SpecializationEntityService {
    
    @Autowired
    private SpecializationRepository specializationRepository;
    
    /**
     * Obtiene la lista completa de especializaciones
     * 
     * @return Lista de especializaciones
     */
    public List<SpecializationEntity> getAllSpecializations() {
        return specializationRepository.findAll();
    }
    
    /**
     * Obtiene el detalle de una consulta por id
     * 
     * @param idSpecialization Id de la especialización
     * @return Detalle de la especialización
     * @throws ResourceNotFoundException en dado caso no se encuentre el recurso
     */
    public ResponseEntity<SpecializationEntity> getSpecializationById(@PathVariable(value = "id") Long idSpecialization)
            throws ResourceNotFoundException {
        
        SpecializationEntity specialization =
                specializationRepository
                    .findById(idSpecialization)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la especialización con el id : " + idSpecialization));
        
        return ResponseEntity.ok().body(specialization);
    }
    
    /**
     * Crea una nueva especialización en la base de datos
     * @param specialization La especialización 
     * @return La especialización creada
     */
    public SpecializationEntity createSpecialization(@Valid @RequestBody SpecializationEntity specialization) {
        return specializationRepository.save(specialization);
    }
    
    /**
     * Actualiza la entidad SpecializationEntity
     * 
     * @param idSpecialization Id de la especialización
     * @param specializationDetails Detalle de la consulta
     * @return La consulta con los datos modificados
     * @throws ResourceNotFoundException en dado caso no se encuentre el recurso
     */
    public ResponseEntity<SpecializationEntity> updateSpecialization(
        @PathVariable(value = "id") Long idSpecialization, @Valid @RequestBody SpecializationEntity specializationDetails)
        throws ResourceNotFoundException {
        
        SpecializationEntity specialization = 
                specializationRepository
                    .findById(idSpecialization)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la especialización con el id : " + idSpecialization));
        
        specialization.setSpecializationName(specializationDetails.getSpecializationName());
        specialization.setDescription(specializationDetails.getDescription());
        
        final SpecializationEntity updatedSpecialization = specializationRepository.save(specialization);
        return ResponseEntity.ok(updatedSpecialization);
    }
    
    /**
     * Elimina una especialización en la base de datos
     * 
     * @param specializationId Id de la especialización
     * @return deleted = true si fue eliminado, false en caso contrario
     * @throws Exception La excepción
     */
    public Map<String, Boolean> deleteSpecialization (@PathVariable(value = "id") Long specializationId)
        throws Exception {
        
        SpecializationEntity specialization = 
                specializationRepository
                    .findById(specializationId)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la especialización con el id : " + specializationId));
        
        specializationRepository.delete(specialization);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return response;
    }
}
