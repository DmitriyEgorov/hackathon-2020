package hackathon.services;

import hackathon.db.model.UserEntity;
import hackathon.db.repository.UserRepository;
import hackathon.model.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserRepresentation> getAllUsers() {
		return userRepository.findAll().stream().map(UserService::getUserRepresentation).collect(Collectors.toList());
	}

	public static UserRepresentation getUserRepresentation(UserEntity userEntity) {
		return UserRepresentation.builder()
				.id(userEntity.getId())
				.name(userEntity.getName()).build();
	}
}
