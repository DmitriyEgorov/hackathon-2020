package hackathon.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CaseRepresentation {
	private Long id;
	private String name;
	private Set<CriteriaRepresentation> criteriaRepresentations;
}
