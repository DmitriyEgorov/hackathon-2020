package app.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "hackathon")
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"hackathon.db.repository"})
@EntityScan(basePackages = {"hackathon.db.model"})
public class TestHackathonApplication {

}
