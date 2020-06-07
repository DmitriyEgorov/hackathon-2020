package hackathon.db.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author egorov
 * @since 06.06.2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "competence")
public class CompetenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;
}
