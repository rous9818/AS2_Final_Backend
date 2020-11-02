package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudDoctorEntity {

    /**
     * @param doctorentity 
     * @return
     */
    public DoctorEntity create(DoctorEntity doctorentity);

    /**
     * @return
     */
    public Set<DoctorEntity> read();

}