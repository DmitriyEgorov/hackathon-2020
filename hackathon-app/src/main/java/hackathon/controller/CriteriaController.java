package hackathon.controller;

import hackathon.model.CompetenceRepresentation;
import hackathon.model.CriteriaRepresentation;
import hackathon.services.CompetenceService;
import hackathon.services.CriteriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/criteria")
public class CriteriaController {

	private final CriteriaService criteriaService;
	private final CompetenceService competenceService;

	public CriteriaController(CriteriaService criteriaService, CompetenceService competenceService) {
		this.criteriaService = criteriaService;
		this.competenceService = competenceService;
	}

	@GetMapping
	public List<CriteriaRepresentation> getAllCriteria() {
		return criteriaService.getAllCriteria();
	}


	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CriteriaRepresentation> getCriteria(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(criteriaService.getCriteria(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}


	@GetMapping("/{id}/competences")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CompetenceRepresentation>> findCompetenceEntityByCategory(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(competenceService.findCompetenceEntityByCriteria(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}


}
