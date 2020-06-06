package hackathon.controller;

import hackathon.model.CaseRepresentation;
import hackathon.model.CaseRepresentationShort;
import hackathon.services.CaseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public List<CaseRepresentationShort> getAllCasesShort() {
        return caseService.getAllCasesShort();
    }

    @GetMapping("/all")
    public List<CaseRepresentation> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public CaseRepresentation getCase(@PathVariable("id") Long id) {
        return caseService.getCase(id);
    }

    @GetMapping("/bycategory")
    public Page<CaseRepresentationShort> getCasesByCategoryId(
            @RequestParam("case_category") Long categoryId,
            @RequestParam("case_type") Long caseType,
            @RequestParam(required = false, name = "case_page") Integer page,
            @RequestParam(required = false, name = "case_count") Integer size) {
        return caseService.getCaseRepresentationByCategory(page, size, categoryId, caseType);
    }
}
