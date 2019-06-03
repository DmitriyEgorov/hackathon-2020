package hackathon.db.repository;

import hackathon.db.model.TestDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author egorov
 * @since 03.06.2019
 */
public interface TestDataEntityRepository extends JpaRepository<TestDataEntity, Long> {
}
