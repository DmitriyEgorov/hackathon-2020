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

	private static CompetenceRepresentation prepareCompetenceRepresentation(CompetenceEntity competenceEntity) {
		return CompetenceRepresentation.builder()
				.id(competenceEntity.getId())
				.name(competenceEntity.getName())
				.build();
	}

	private static CompetenceEntity prepareCompetenceEntity(CompetenceRepresentation competenceRepresentation) {
		return CompetenceEntity.builder()
				.id(competenceRepresentation.getId())
				.name(competenceRepresentation.getName())
				.build();
	}

}
