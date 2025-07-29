package hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "hexagonal.adapters",
        "hexagonal.ports",
        "hexagonal.core",
        "hexagonal.config"
})
@EnableJpaRepositories(basePackages = "hexagonal.adapters.out.repositories.jpa")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
