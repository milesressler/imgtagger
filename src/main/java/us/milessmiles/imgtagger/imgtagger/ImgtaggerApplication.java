package us.milessmiles.imgtagger.imgtagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ImgtaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImgtaggerApplication.class, args);
	}

}
