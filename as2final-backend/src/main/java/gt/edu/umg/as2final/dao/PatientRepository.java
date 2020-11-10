package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio PatientRepository
 * @author AK272DT
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {}
