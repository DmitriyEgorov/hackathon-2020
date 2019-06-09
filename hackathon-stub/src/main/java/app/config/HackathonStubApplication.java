package app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * stub boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "stub")
@EnableWebMvc
@PropertySource("classpath:stub.properties")
@EnableJpaRepositories(basePackages = {"stub.db.repository"})
@EntityScan(basePackages = {"stub.db.model"})
public class HackathonStubApplication {

    private final Environment environment;

    public HackathonStubApplication (Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(HackathonStubApplication.class, args);
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.stub.driver.class.name"));
        dataSource.setUrl(environment.getProperty("db.stub.url"));
        dataSource.setUsername(environment.getProperty("db.stub.username"));
        dataSource.setPassword(environment.getProperty("db.stub.password"));
        return dataSource;
    }
}
