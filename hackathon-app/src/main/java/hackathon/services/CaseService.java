package hackathon.services;

import hackathon.db.model.CaseEntity;
import hackathon.model.CaseRepresentation;
import hackathon.db.repository.CaseRepository;
import hackathon.model.CriteriaRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Service
public class CaseService {

	private final CaseRepository caseRepository;

	public CaseService(CaseRepository caseRepository) {
		this.caseRepository = caseRepository;
	}

	public List<CaseRepresentation> getAllCases() {
		return caseRepository.findAll().stream()
				.map(CaseService::prepareCaseRepresentation)
				.collect(Collectors.toList());
	}

	private static CaseRepresentation prepareCaseRepresentation(CaseEntity caseEntity) {
		Set<CriteriaRepresentation> criteriaRepresentations = caseEntity.getCriteriaEntities().stream()
				.map(CriteriaService::prepareCriteriaRepresentation)
				.collect(Collectors.toSet());
		return CaseRepresentation.builder()
				.id(caseEntity.getId())
				.name(caseEntity.getName())
				.criteriaRepresentations(criteriaRepresentations)
				.build();
	}

	public static List<CaseRepresentation> prepareCaseRepresentationList(List<CaseEntity> caseEntities) {
		return caseEntities.stream().map(CaseService::prepareCaseRepresentation).collect(Collectors.toList());
	}
}
