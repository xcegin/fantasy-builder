package sk.cegin.fantasybuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("sk.cegin.fantasybuilder.repository")
@EntityScan("sk.cegin.fantasybuilder.entity")
public class FantasybuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FantasybuilderApplication.class, args);
    }

}
