package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio MedicineRepository
 * @author AK272DT
 */
@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {}
