package hackathon.db.repository;

import hackathon.db.model.CompetenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceEntity, Long> {

    @Query(nativeQuery = true, value =
            "SELECT c.id, c.name from hackathon_test.competence c join hackathon_test.competence_user u on c.id = u.competence_id where u.user_id = :userId")
    List<CompetenceEntity> findCompetenceEntityByUser(@Param("userId") Long userId);
}
