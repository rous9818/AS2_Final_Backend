package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.DoctorSpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio DoctorSpecializationRepository
 * @author AK272DT
 */
@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecializationEntity, Long> {}
