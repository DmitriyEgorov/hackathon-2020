package hackathon.db.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GRADES")
public class GradeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "VALUE")
	private Long value;

	@Column(name = "AUTHOR_ID")
	private Long authorId;

	@Column(name = "CASE_ID")
	private Long caseId;

}
