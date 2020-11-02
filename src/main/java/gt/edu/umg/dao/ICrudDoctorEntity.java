package as2final_hospital.gt.edu.umg.as2final_hospital.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudDoctorEntity {

    /**
     * @param doctoentity 
     * @return
     */
    public DoctorEntity create(DoctorEntity doctoentity);

    /**
     * @return
     */
    public Set<DoctorEntity> read();

}