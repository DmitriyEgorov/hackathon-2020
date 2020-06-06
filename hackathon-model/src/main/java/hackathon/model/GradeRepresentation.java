package hackathon.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class GradeRepresentation {
	private Long id;
	private Long value;
	private Long authorId;
}
