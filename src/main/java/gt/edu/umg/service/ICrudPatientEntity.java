package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudPatientEntity {

    /**
     * @param patiententity 
     * @return
     */
    public PatientEntity create(PatientEntity patiententity);

    /**
     * @return
     */
    public Set<PatientEntity> read();

}