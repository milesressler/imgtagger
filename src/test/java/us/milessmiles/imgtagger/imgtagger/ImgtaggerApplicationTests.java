package us.milessmiles.imgtagger.imgtagger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ImgtaggerApplicationTests {


	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

}
