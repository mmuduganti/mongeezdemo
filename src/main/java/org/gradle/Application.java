package org.gradle;

import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.mongodb.Mongo;

@EnableAutoConfiguration
@EnableMongoAuditing
public class Application implements CommandLineRunner {

	@Autowired
	Mongo mongoClient;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("mongeez.xml"));
		mongeez.setMongo(mongoClient);
		mongeez.setDbName("mongeeztest");
		mongeez.process(); 
	}

}
