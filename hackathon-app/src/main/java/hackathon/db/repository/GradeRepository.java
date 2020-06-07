package hackathon.db.repository;

import hackathon.db.model.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
	List<GradeEntity> findAll();
	List<GradeEntity> findByAuthorId(Long userId);
}
