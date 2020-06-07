package hackathon.db.repository;

import hackathon.db.model.CriteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface CriteriaRepository extends JpaRepository<CriteriaEntity, Long> {
	List<CriteriaEntity> findAll();
}
