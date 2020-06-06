package hackathon.services;

import hackathon.db.model.CaseEntity;
import hackathon.db.repository.CasePagebleRepository;
import hackathon.model.CaseRepresentation;
import hackathon.db.repository.CaseRepository;
import hackathon.model.CriteriaRepresentation;
import hackathon.model.GradeRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Service
public class CaseService {

	private final CaseRepository caseRepository;
	private final CasePagebleRepository casePagebleRepository;

	public CaseService(CaseRepository caseRepository, CasePagebleRepository casePagebleRepository) {
		this.caseRepository = caseRepository;
		this.casePagebleRepository = casePagebleRepository;
	}

	public List<CaseRepresentation> getAllCases() {
		return caseRepository.findAll().stream()
				.map(CaseService::prepareCaseRepresentation)
				.collect(Collectors.toList());
	}

	public Page<CaseEntity> getCasesByCategory(Integer page, Integer size, Long categoryId) {
		int pageNum = page != null ? page : 0;
		int pageSize = size != null ? size : 10;
		return casePagebleRepository.findByCategoryId(categoryId, PageRequest.of(pageNum, pageSize));
	}

	private static CaseRepresentation prepareCaseRepresentation(CaseEntity caseEntity) {
		List<CriteriaRepresentation> criteriaRepresentations = caseEntity.getCriteriaEntities().stream()
				.map(CriteriaService::prepareCriteriaRepresentation)
				.collect(Collectors.toList());
		List<GradeRepresentation> gradeRepresentations = caseEntity.getGradeEntitySet().stream()
				.map(GradeService::prepareGradeRepresentation)
				.collect(Collectors.toList());
		return CaseRepresentation.builder()
				.id(caseEntity.getId())
				.name(caseEntity.getName())
				.criteriaRepresentations(criteriaRepresentations)
				.gradeRepresentations(gradeRepresentations)
				.build();
	}

	public static List<CaseRepresentation> prepareCaseRepresentationList(List<CaseEntity> caseEntities) {
		return caseEntities.stream().map(CaseService::prepareCaseRepresentation).collect(Collectors.toList());
	}
}
