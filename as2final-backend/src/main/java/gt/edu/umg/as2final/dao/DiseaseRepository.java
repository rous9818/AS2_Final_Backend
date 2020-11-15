package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio DiseaseRepository
 * @author AK272DT
 */
@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long> {}
