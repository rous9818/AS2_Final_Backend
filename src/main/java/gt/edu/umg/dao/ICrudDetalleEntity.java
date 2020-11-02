package as2final_hospital.gt.edu.umg.as2final_hospital.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudDetalleEntity {

    /**
     * @param detallentity 
     * @return
     */
    public DetalleEntity create(DetalleEntity detallentity);

    /**
     * @return
     */
    public Set<DetalleEntity> read();

}