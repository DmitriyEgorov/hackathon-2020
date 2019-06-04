package hackathon.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@Import(HackathonApplication.class)
public class TestHackathonApplication {

}
