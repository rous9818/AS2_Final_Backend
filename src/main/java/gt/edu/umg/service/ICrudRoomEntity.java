package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudRoomEntity {

    /**
     * @param roomentity 
     * @return
     */
    public RoomEntity create(RoomEntity roomentity);

    /**
     * @return
     */
    public Set<RoomEntity> read();

}