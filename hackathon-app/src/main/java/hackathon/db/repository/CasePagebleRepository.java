package hackathon.db.repository;

import hackathon.db.model.CaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface CasePagebleRepository extends PagingAndSortingRepository<CaseEntity, Long> {
	Page<CaseEntity> findByCategoryIdAndCaseType(Long categoryId, Long caseType, Pageable pageable);

	List<CaseEntity>findByCategoryId(Long categoryId, Pageable pageable);

	List<CaseEntity>findByCaseType(Long caseType, Pageable pageable);
}
