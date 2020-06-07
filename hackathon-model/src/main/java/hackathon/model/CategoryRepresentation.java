package hackathon.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CategoryRepresentation {
	private Long id;
	private Long parentCategory;
	private List<CaseRepresentation> caseRepresentations;
	private String name;
}
