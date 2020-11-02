package as2final_hospital.gt.edu.umg.as2final_hospital.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudQueryDetailEntity {

    /**
     * @param querydetailentity 
     * @return
     */
    public QueryDetailEntity create(QueryDetailEntity querydetailentity);

    /**
     * @return
     */
    public Set<QueryDetailEntity> read();

}