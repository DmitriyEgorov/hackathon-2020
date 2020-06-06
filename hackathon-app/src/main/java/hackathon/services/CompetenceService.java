package hackathon.services;

import hackathon.db.model.CompetenceEntity;
import hackathon.db.repository.CompetenceRepository;
import hackathon.model.CompetenceRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Service
public class CompetenceService {

	private final CompetenceRepository competenceRepository;

	public CompetenceService(CompetenceRepository competenceRepository) {
		this.competenceRepository = competenceRepository;
	}

	public List<CompetenceRepresentation> getAllCompetences() {
		return competenceRepository.findAll().stream()
				.map(CompetenceService::prepareCompetenceRepresentation)
				.collect(Collectors.toList());
	}

	public CompetenceRepresentation getCompetence(Long id) {
		return prepareCompetenceRepresentation(competenceRepository.getOne(id));
	}

	public CompetenceRepresentation createCompetence(CompetenceRepresentation competenceRepresentation) {
		return prepareCompetenceRepresentation(competenceRepository.save(prepareCompetenceEntity(competenceRepresentation)));
	}

	public List<CompetenceRepresentation>  findCompetenceEntityByUser (Long userId) {
		return competenceRepository.findCompetenceEntityByUser(userId).stream()
				.map(CompetenceService::prepareCompetenceRepresentation)
				.collect(Collectors.toList());
	}

	public List<CompetenceRepresentation>  findCompetenceEntityByCriteria (Long criteriaId) {
		return competenceRepository.findCompetenceEntityByCriteria(criteriaId).stream()
				.map(CompetenceService::prepareCompetenceRepresentation)
				.collect(Collectors.toList());
	}

	private static CompetenceRepresentation prepareCompetenceRepresentation(CompetenceEntity competenceEntity) {
		CompetenceRepresentation competenceRepresentation = new CompetenceRepresentation();
		competenceRepresentation.setId(competenceEntity.getId());
		competenceRepresentation.setName(competenceEntity.getName());
		return competenceRepresentation;
	}

	private static CompetenceEntity prepareCompetenceEntity(CompetenceRepresentation competenceRepresentation) {
		return CompetenceEntity.builder()
				.id(competenceRepresentation.getId())
				.name(competenceRepresentation.getName())
				.build();
	}

}
