package hackathon.services;

import hackathon.db.model.CaseEntity;
import hackathon.db.repository.CasePagebleRepository;
import hackathon.model.CaseRepresentation;
import hackathon.db.repository.CaseRepository;
import hackathon.model.CaseRepresentationShort;
import hackathon.model.CriteriaRepresentation;
import hackathon.model.GradeRepresentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Service
public class CaseService {

    private final CaseRepository caseRepository;
    private final CasePagebleRepository casePagebleRepository;

    public CaseService(CaseRepository caseRepository, CasePagebleRepository casePagebleRepository) {
        this.caseRepository = caseRepository;
        this.casePagebleRepository = casePagebleRepository;
    }

    public List<CaseRepresentation> getAllCases() {
        return caseRepository.findAll().stream()
                .map(CaseService::prepareCaseRepresentation)
                .collect(Collectors.toList());
    }

    public List<CaseRepresentationShort> getAllCasesShort() {
        return caseRepository.findAll().stream()
                .map(CaseService::prepareCaseRepresentationShort)
                .collect(Collectors.toList());
    }

    public CaseRepresentation getCase(Long id) {
        return prepareCaseRepresentation(caseRepository.getOne(id));
    }

    public Page<CaseRepresentationShort> getCaseRepresentationByCategory(Integer page, Integer size, Long categoryId, Long caseType) {
        return (categoryId == null || caseType == null) ?
                getCasesByCategory(page, size).map(CaseService::prepareCaseRepresentationShort) :
                getCasesByCategory(page, size, categoryId, caseType).map(CaseService::prepareCaseRepresentationShort);
    }

    private Page<CaseEntity> getCasesByCategory(Integer page, Integer size, Long categoryId, Long caseType) {
        int pageNum = page != null ? page : 0;
        int pageSize = size != null ? size : 10;
        return casePagebleRepository.findByCategoryIdAndCaseType(categoryId, caseType, PageRequest.of(pageNum, pageSize));
    }

    private Page<CaseEntity> getCasesByCategory(Integer page, Integer size) {
        int pageNum = page != null ? page : 0;
        int pageSize = size != null ? size : 10;
        return casePagebleRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    private static CaseRepresentation prepareCaseRepresentation(CaseEntity caseEntity) {
        List<CriteriaRepresentation> criteriaRepresentations = caseEntity.getCriteriaEntities().stream()
                .map(CriteriaService::prepareCriteriaRepresentation)
                .collect(Collectors.toList());
        List<GradeRepresentation> gradeRepresentations = caseEntity.getGradeEntitySet().stream()
                .map(GradeService::prepareGradeRepresentation)
                .collect(Collectors.toList());
        return CaseRepresentation.builder()
                .id(caseEntity.getId())
                .name(caseEntity.getName())
                .criteriaRepresentations(criteriaRepresentations)
                .gradeRepresentations(gradeRepresentations)
                .statDate(caseEntity.getStatDate() == null ? null : caseEntity.getStatDate().toString())
                .preview(caseEntity.getDescription() == null ? null :
                        caseEntity.getDescription().substring(
                                0,
                                caseEntity.getDescription().length() < 100 ? caseEntity.getDescription().length() : 100))
                .imagePath(caseEntity.getImagePath())
                .build();
    }

    private static CaseRepresentationShort prepareCaseRepresentationShort(CaseEntity caseEntity) {
        return CaseRepresentationShort.builder()
                .id(caseEntity.getId())
                .name(caseEntity.getName())
                .statDate(caseEntity.getStatDate() == null ? null : caseEntity.getStatDate().toString())
                .preview(caseEntity.getDescription() == null ? null :
                        caseEntity.getDescription().substring(
                                0,
                                caseEntity.getDescription().length() < 100 ? caseEntity.getDescription().length() : 100))
                .imagePath(caseEntity.getImagePath())
                .build();
    }

    public static List<CaseRepresentation> prepareCaseRepresentationList(List<CaseEntity> caseEntities) {
        return caseEntities.stream().map(CaseService::prepareCaseRepresentation).collect(Collectors.toList());
    }
}
