package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.SpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio SpecializationRepository
 * @author AK272DT
 */
@Repository
public interface SpecializationRepository extends JpaRepository<SpecializationEntity, Long> {}
