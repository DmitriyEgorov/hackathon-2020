package hackathon.controller;

import hackathon.db.model.CaseEntity;
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

	@GetMapping("/bycategory")
	public Page<CaseEntity> getCasesByCategoryId(@RequestParam("id") Long categoryId, @RequestParam(required = false, name = "page") Integer page,
	                                             @RequestParam(required = false, name = "size") Integer size) {
		return caseService.getCasesByCategory(page, size, categoryId);
	}
}
