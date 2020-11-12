package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio PrescriptionRepository
 * @author AK272DT
 */
@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {}
