package hackathon.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */

public class CompetenceRepresentation {
	private Long id;
	private String name;

	public CompetenceRepresentation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
