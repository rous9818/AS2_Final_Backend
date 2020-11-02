package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudBedEntity {

    /**
     * @param bedentity 
     * @return
     */
    public BedEntity create(BedEntity bedentity);

    /**
     * @return
     */
    public Set<BedEntity> read();

}