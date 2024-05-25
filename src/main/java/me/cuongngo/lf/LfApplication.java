package me.cuongngo.lf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"me.cuongngo.lf.services"})
//@EntityScan("me.cuongngo.lf.models")
//@EnableJpaRepositories("me.cuongngo.lf.repositories")
public class LfApplication {

	public static void main(String[] args) {
		SpringApplication.run(LfApplication.class, args);
	}

}
