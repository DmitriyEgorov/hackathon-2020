package hackathon.services;

import hackathon.db.model.CriteriaEntity;
import hackathon.db.repository.CriteriaRepository;
import hackathon.model.CriteriaRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Service
public class CriteriaService {

	private final CriteriaRepository criteriaRepository;


	public CriteriaService(CriteriaRepository criteriaRepository) {
		this.criteriaRepository = criteriaRepository;
	}

	public List<CriteriaRepresentation> getAllCriteria() {
		return criteriaRepository.findAll().stream()
				.map(CriteriaService::prepareCriteriaRepresentation)
				.collect(Collectors.toList());
	}

	public static CriteriaRepresentation prepareCriteriaRepresentation(CriteriaEntity criteriaEntity) {
		return CriteriaRepresentation.builder()
				.id(criteriaEntity.getId())
				.name(criteriaEntity.getName()).build();
	}
}
