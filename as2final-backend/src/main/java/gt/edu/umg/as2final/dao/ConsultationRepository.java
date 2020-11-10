package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio ConsultationRepository
 * @author AK272DT
 */
@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {}
