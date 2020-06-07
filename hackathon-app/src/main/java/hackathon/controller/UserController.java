package hackathon.controller;

import hackathon.model.CompetenceRepresentation;
import hackathon.model.UserRepresentation;
import hackathon.services.CompetenceService;
import hackathon.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Albert
 * Created at 06.06.2020.06.2020
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final CompetenceService competenceService;

    public UserController(UserService userService, CompetenceService competenceService) {
        this.userService = userService;
        this.competenceService = competenceService;
    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRepresentation> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<UserRepresentation> getUser(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/competences")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<CompetenceRepresentation>> getUserCompetences(@PathVariable("id") Long id) {
        return ResponseEntity.ok(competenceService.findCompetenceEntityByUser(id));
    }

}
