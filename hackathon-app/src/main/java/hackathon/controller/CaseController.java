package hackathon.controller;

import hackathon.model.CaseRepresentation;
import hackathon.services.CaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/cases")
public class CaseController {

	private final CaseService caseService;

	public CaseController(CaseService caseService) {
		this.caseService = caseService;
	}

	@GetMapping
	public List<CaseRepresentation> getAllCases() {
		return caseService.getAllCases();
	}

	@GetMapping("/{id}")
	public CaseRepresentation getCase(@PathVariable("id") Long id) {
		return caseService.getCase(id);
	}
}
