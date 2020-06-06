package hackathon.controller;

import hackathon.model.CriteriaRepresentation;
import hackathon.services.CriteriaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/criteria")
public class CriteriaController {

	private final CriteriaService criteriaService;

	public CriteriaController(CriteriaService criteriaService) {
		this.criteriaService = criteriaService;
	}

	@GetMapping
	public List<CriteriaRepresentation> getAllCriteria() {
		return criteriaService.getAllCriteria();
	}
}
