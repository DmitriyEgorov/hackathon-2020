package app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:stub.properties")
public class TestHackathonStubApplication {

   public static void main(String[] args) {
        SpringApplication.run(TestHackathonStubApplication.class, args);
    }

}
