package hackathon.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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

	@Column(name = "CATEGORY_ID")
	private Long categoryId;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "CASE_TO_CRITERIA",
			joinColumns = @JoinColumn(name = "CASE_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "CRITERIA_ID", referencedColumnName = "id"))
	private Set<CriteriaEntity> criteriaEntities;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CASE_ID")
	private Set<GradeEntity> gradeEntitySet;

    @Column(name = "START_DATE")
    private LocalDate statDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_PATH")
    private String imagePath;
}
