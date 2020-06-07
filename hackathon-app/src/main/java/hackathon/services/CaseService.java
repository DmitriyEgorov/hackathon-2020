package hackathon.services;

import hackathon.db.model.CaseEntity;
import hackathon.db.repository.CasePagebleRepository;
import hackathon.model.*;
import hackathon.db.repository.CaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<CaseRepresentationShort> getAllCasesShortParam(Integer size, Long categoryId, Long caseType) {
        return getCasesByCategory(size, categoryId, caseType)
                .stream()
                .map(CaseService::prepareCaseRepresentationShort)
                .collect(Collectors.toList());
    }

    public CaseRepresentation getCase(Long id) {
        return prepareCaseRepresentation(caseRepository.getOne(id));
    }

    public CaseRepresentationDetailShort getCaseShort(Long id) {
        return prepareCaseRepresentationDetailShort(caseRepository.getOne(id));
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

    private List<CaseEntity> getCasesByCategory(Integer size, Long categoryId, Long caseType) {
        List<CaseEntity> caseEntities;
        Pageable pageable = PageRequest.of(0, size == null ? 9 : size);
        if(categoryId != null) {
            if(categoryId == 0) {
                caseEntities = getCasesByCaseType(caseType, pageable);
            }
            else {
                if (caseType != null) {
                    caseEntities = casePagebleRepository.findByCategoryIdAndCaseType(categoryId, caseType, pageable).getContent();
                } else {
                    caseEntities = casePagebleRepository.findByCategoryId(categoryId, pageable);
                }
            }
        } else {
            caseEntities = getCasesByCaseType(caseType, pageable);
        }
        return caseEntities;
    }

    private List<CaseEntity> getCasesByCaseType(Long caseType, Pageable pageable) {
        List<CaseEntity> caseEntities;
        if(caseType != null) {
            caseEntities = casePagebleRepository.findByCaseType(caseType, pageable);
        } else {
            caseEntities = new ArrayList<>(caseRepository.findAll(pageable).getContent());
        }
        return caseEntities;
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
                .category(caseEntity.getCategoryId().toString())
                .type(caseEntity.getCaseType().toString())
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
                .category(caseEntity.getCategoryId().toString())
                .type(caseEntity.getCaseType().toString())
                .build();
    }

    private static CaseRepresentationDetailShort prepareCaseRepresentationDetailShort(CaseEntity caseEntity) {
        return CaseRepresentationDetailShort.builder()
                .id(caseEntity.getId())
                .name(caseEntity.getName())
                .statDate(caseEntity.getStatDate() == null ? null : caseEntity.getStatDate().toString())
                .text(caseEntity.getDescription())
                .imagePath(caseEntity.getImagePath())
                .category(caseEntity.getCategoryId().toString())
                .type(caseEntity.getCaseType().toString())
                .build();
    }

    public static List<CaseRepresentation> prepareCaseRepresentationList(List<CaseEntity> caseEntities) {
        return caseEntities.stream().map(CaseService::prepareCaseRepresentation).collect(Collectors.toList());
    }
}
