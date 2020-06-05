package hackathon.controller;

import hackathon.model.CompetenceRepresentation;
import hackathon.services.CompetenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CompetenceRepresentation>> getAllCompetences() {
		return ResponseEntity.ok(competenceService.getAllCompetences());
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CompetenceRepresentation> getCompetence(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(competenceService.getCompetence(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CompetenceRepresentation> createCompetence(@RequestBody CompetenceRepresentation competenceRepresentation) {
		try {
			return ResponseEntity.ok(competenceService.createCompetence(competenceRepresentation));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CompetenceRepresentation> updateCompetence(@RequestBody CompetenceRepresentation competenceRepresentation) {
		try {
			return ResponseEntity.ok(competenceService.createCompetence(competenceRepresentation));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
