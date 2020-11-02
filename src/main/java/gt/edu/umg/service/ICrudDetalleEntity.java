package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudDetalleEntity {

    /**
     * @param detalleentity 
     * @return
     */
    public DetalleEntity create(DetalleEntity detalleentity);

    /**
     * @return
     */
    public Set<DetalleEntity> read();

}