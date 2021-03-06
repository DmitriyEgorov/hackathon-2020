package app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "stub")
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"stub.db.repository"})
@EntityScan(basePackages = {"stub.db.model"})
public class TestHackathonStubApplication {

   public static void main(String[] args) {
        SpringApplication.run(TestHackathonStubApplication.class, args);
    }

}
