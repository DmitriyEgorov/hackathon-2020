package hackathon.db.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Albert
 * Created at 05.06.2020.06.2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CASES")
public class CaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CASE_TO_CRITERIA",
			joinColumns = @JoinColumn(name = "CASE_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "CRITERIA_ID", referencedColumnName = "id"))
	private Set<CriteriaEntity> criteriaEntities;
}
