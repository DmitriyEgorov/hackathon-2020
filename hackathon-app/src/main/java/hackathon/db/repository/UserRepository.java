package hackathon.db.repository;

import hackathon.db.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findAll();
	Optional<UserEntity> findById(Long userId);
}
