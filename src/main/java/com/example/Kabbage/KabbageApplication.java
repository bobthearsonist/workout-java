package com.example.Kabbage;

import com.example.Kabbage.repositories.UserRepository;
import com.example.Kabbage.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KabbageApplication {

	public static void main(final String[] args) {
		SpringApplication.run(KabbageApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			final User martin = User.builder().userName("dislexicmofo").build();
			userRepository.save(martin);

			final Muscle bicep = Muscle.builder()
			final Body standardBody = Body.builder().
		};
	}
}
