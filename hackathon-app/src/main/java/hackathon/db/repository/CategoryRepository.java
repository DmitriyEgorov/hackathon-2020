package hackathon.db.repository;

import hackathon.db.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	List<CategoryEntity> findAll();
}
