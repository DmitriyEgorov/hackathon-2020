package hackathon.services;

import hackathon.db.model.CaseEntity;
import hackathon.db.model.CategoryEntity;
import hackathon.db.repository.CategoryRepository;
import hackathon.model.CategoryRepresentation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryRepresentation> getAllCategories() {
		return categoryRepository.findAll().stream()
				.map(CategoryService::prepareCategoryRepresentation)
				.collect(Collectors.toList());
	}

	public static CategoryRepresentation prepareCategoryRepresentation(CategoryEntity categoryEntity) {
		return CategoryRepresentation.builder()
				.id(categoryEntity.getId())
				.parentCategory(categoryEntity.getParentId())
				.name(categoryEntity.getCategoryName())
				.caseRepresentations(CaseService.prepareCaseRepresentationList(new ArrayList<>(categoryEntity.getCaseEntities())))
				.build();
	}
}
