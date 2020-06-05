package hackathon.db.repository;

import hackathon.db.model.CompetenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceEntity, Long> {
}
