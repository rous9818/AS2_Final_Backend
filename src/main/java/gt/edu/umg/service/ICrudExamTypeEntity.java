package as2final_hospital.gt.edu.umg.as2final_hospital.service;

import java.util.*;

/**
 * 
 */
public interface ICrudExamTypeEntity {

    /**
     * @param examtypeentity 
     * @return
     */
    public ExamTypeEntity create(ExamTypeEntity examtypeentity);

    /**
     * @return
     */
    public ExamTypeEntity read();

}