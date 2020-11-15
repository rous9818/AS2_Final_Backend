/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.as2final.service;

import gt.edu.umg.as2final.dao.DoctorSpecializationRepository;
import gt.edu.umg.as2final.model.DoctorSpecializationEntity;
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
 * Servicio DoctorSpecializationEntityService
 * Permite implementar todas las operaciones del CRUD para le entidad DoctorSpecializationEntity
 * @author AK272DT
 */

@Service
public class DoctorSpecializationEntityService {
    
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;
    
    /**
     * Obtiene la lista completa de asignaciones especialización -> doctor
     * @return Lista de asignaciones
     */
    public List<DoctorSpecializationEntity> getAllDoctorSpecializations() {
        return doctorSpecializationRepository.findAll();
    }
    
    /**
     * Obtiene el detalle de una asignación por id
     * @param idDoctorSpecialization
     * @return Detalle de la asignación
     * @throws ResourceNotFoundException en dado caso no encuentre el recurso
     */
    public ResponseEntity<DoctorSpecializationEntity> getDoctorSpecializationById(@PathVariable(value = "id") Long idDoctorSpecialization)
        throws ResourceNotFoundException {
        
        DoctorSpecializationEntity doctorSpecialization = 
                doctorSpecializationRepository
                    .findById(idDoctorSpecialization)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la consulta con el id : " + idDoctorSpecialization));
        
        return ResponseEntity.ok().body(doctorSpecialization);
    }
    
    /**
     * Crea una nueva consulta médica en la base de datos.
     * @param doctorSpecialization La asignación
     * @return  La asignación creada
     */
    public DoctorSpecializationEntity createDoctorSpecialization(@Valid @RequestBody DoctorSpecializationEntity doctorSpecialization) {
        return doctorSpecializationRepository.save(doctorSpecialization);
    }
    
    /**
     * Método solo como referencia, debido a que no se debe permitir actualizar la asignación
     * @param idDoctorSpecialization
     * @param doctorSpecializationDetails
     * @return La asignación
     * @throws ResourceNotFoundException en dado caso no encuentre el recurso 
     */
    public ResponseEntity<DoctorSpecializationEntity> updateDoctorSpecialization (
        @PathVariable(value = "id") Long idDoctorSpecialization, @Valid @RequestBody DoctorSpecializationEntity doctorSpecializationDetails)
        throws ResourceNotFoundException {
        
        DoctorSpecializationEntity doctorSpecialization = 
                doctorSpecializationRepository
                    .findById(idDoctorSpecialization)
                    .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado la asignación con el id : " + idDoctorSpecialization));
        
        final DoctorSpecializationEntity updatedDoctorSpecialization = doctorSpecializationRepository.save(doctorSpecialization);
        return ResponseEntity.ok(updatedDoctorSpecialization);
    }
    
    /**
     * Elimina una consulta de la base de datos
     * 
     * @param doctorSpecializationId Id de la asignación
     * @return deleted = true si fue eliminado, false en caso contrario
     * @throws Exception La excepción
     */
    public Map<String, Boolean> deleteDoctorSpecialization (@PathVariable(value = "id") Long doctorSpecializationId)
        throws Exception {
        
        DoctorSpecializationEntity doctorSpecialization = 
                doctorSpecializationRepository
                    .findById(doctorSpecializationId)
                    .orElseThrow(() -> new ResourceNotFoundException("No se encontró la asignación con el id : " + doctorSpecializationId));
        
        doctorSpecializationRepository.delete(doctorSpecialization);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        
        return response;
    }
}
