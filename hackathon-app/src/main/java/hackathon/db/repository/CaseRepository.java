package hackathon.db.repository;

import hackathon.db.model.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, Long> {
	List<CaseEntity> findAll();
}
