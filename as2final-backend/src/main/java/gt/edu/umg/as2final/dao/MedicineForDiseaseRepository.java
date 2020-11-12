package gt.edu.umg.as2final.dao;

import gt.edu.umg.as2final.model.MedicineForDiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio MedicineForDiseaseRepository
 * @author AK272DT
 */
@Repository
public interface MedicineForDiseaseRepository extends JpaRepository<MedicineForDiseaseEntity, Long> {}
