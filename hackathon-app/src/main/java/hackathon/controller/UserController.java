package hackathon.controller;

import hackathon.model.UserRepresentation;
import hackathon.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<UserRepresentation> getAllUsers() {
		return userService.getAllUsers();
	}
}
