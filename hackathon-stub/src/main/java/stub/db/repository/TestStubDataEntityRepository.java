package stub.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stub.db.model.TestStubDataEntity;

/**
 * @author egorov
 * @since 03.06.2019
 */
public interface TestStubDataEntityRepository extends JpaRepository<TestStubDataEntity, Long> {
}
