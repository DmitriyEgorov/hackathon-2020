package hackathon.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CaseRepresentationShort {
	private Long id;
	private String name;
	private String statDate;
	private String preview;
	private String imagePath;
	private String category;
	private String type;
}
