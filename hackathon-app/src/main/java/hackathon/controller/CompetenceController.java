package hackathon.controller;

import hackathon.model.CompetenceRepresentation;
import hackathon.model.UserRepresentation;
import hackathon.services.CompetenceService;
import hackathon.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/competences")
public class CompetenceController {

	private final CompetenceService competenceService;

	public CompetenceController(CompetenceService competenceService) {
		this.competenceService = competenceService;
	}

	@GetMapping
	public List<CompetenceRepresentation> getAllUsers() {
		return competenceService.getAllCompetences();
	}
}
