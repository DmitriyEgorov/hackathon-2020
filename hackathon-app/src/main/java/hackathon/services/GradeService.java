package hackathon.services;

import hackathon.db.model.GradeEntity;
import hackathon.db.repository.GradeRepository;
import hackathon.model.GradeRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Service
public class GradeService {

	private final GradeRepository gradeRepository;

	public GradeService(GradeRepository gradeRepository, UserService userService) {
		this.gradeRepository = gradeRepository;
	}

	public List<GradeRepresentation> getAllUSerGrades(Long userId) {
		return gradeRepository.findByAuthorId(userId).stream()
				.map(GradeService::prepareGradeRepresentation)
				.collect(Collectors.toList());
	}

	public static GradeRepresentation prepareGradeRepresentation(GradeEntity gradeEntity) {
		return GradeRepresentation.builder()
				.id(gradeEntity.getId())
				.authorId(gradeEntity.getAuthorId())
				.build();
	}

}
